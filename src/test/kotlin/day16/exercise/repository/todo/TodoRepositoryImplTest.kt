package day16.exercise.repository.todo

import day16.exercise.datasource.todo.TodoDataSourceImpl
import day16.util.Const
import day16.util.createMockEngine
import io.ktor.client.engine.mock.*
import io.ktor.client.network.sockets.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.fail


class TodoRepositoryImplTest {


    @Test
    fun `getTodos 성공 케이스`() = runTest {
        val mockEngine = createMockEngine { request ->
            if (request.url.toString() == Const.TODOS_URL) {
                respond(
                    content = """
                             [
                                    {"id": 1, "title": "Todo 1", "completed": false},
                                    {"id": 2, "title": "Todo 2", "completed": true}
                              ]
         
                         """,
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                )
            } else {
                println("통신 에러")
                respondBadRequest()
            }
        }


        val testDataSource = TodoRepositoryImpl(TodoDataSourceImpl(mockEngine))
        val todos = testDataSource.getTodos()

        assertEquals(2, todos.size)
        assertEquals(1, todos[0].id)
        assertEquals("Todo 1", todos[0].title)
        assertEquals(false, todos[0].completed)
    }

    @Test
    fun `getTodo 성공 케이스`() = runTest {
        val mockEngine = createMockEngine { request ->
            if (request.url.toString() == "${Const.TODOS_URL}/1") {
                respond(
                    content = """           
                                {"id": 1, "title": "Todo 1", "completed": false}
                              """,
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                )
            } else {
                println("통신 에러")
                respondBadRequest()
            }
        }

        val testDataSource = TodoRepositoryImpl(TodoDataSourceImpl(mockEngine))
        val todos = testDataSource.getTodo(1)
        assertEquals(1, todos?.id ?: 0)
        assertEquals("Todo 1", todos?.title ?: "Unknown")
        assertEquals(false, todos?.completed ?: false)
    }

    @Test
    fun `네트워크 에러 케이스`() = runTest {
        val mockEngine = createMockEngine {
            throw throw ConnectTimeoutException("TimeOut")
        }

        val testDataSource = TodoRepositoryImpl(TodoDataSourceImpl(mockEngine))

        try {
            val response = testDataSource.getTodos()
            println("응답: $response")
        } catch (e: ConnectTimeoutException) {
            println("실패: ${e.message}")
        }
    }

    @Test
    fun `존재하지 않는 ID 요청 케이스`() = runTest {
        val mockClient = createMockEngine { request ->
            if (request.url.encodedPath == "/todos/0") {
                respond(
                    content = "{}",
                    status = HttpStatusCode.NotFound,
                    headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                )
            } else {
                error("Unhandled request")
            }
        }

        val dataSource = TodoRepositoryImpl(TodoDataSourceImpl(mockClient))

        try {
            dataSource.getTodo(0)
            fail("Expected exception not thrown")
        } catch (e: IllegalArgumentException) {
            assertEquals("Todo with ID 0 not found", e.message)
        }
    }
}