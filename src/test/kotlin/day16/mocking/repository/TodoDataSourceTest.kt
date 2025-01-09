package day16.mocking.repository

import day16.util.createMockClient
import io.ktor.client.engine.mock.*
import io.ktor.client.network.sockets.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import org.hyunjung.day16.mocking.datasource.TodoDataSource
import org.hyunjung.day16.mocking.datasource.TodoDataSourceImpl
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class TodoDataSourceTest {
    @Test
    fun `getTodos 성공 케이스`() = runBlocking {
        val mockClient = createMockClient { request ->
            if (request.url.encodedPath == "/todos") {
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
                error("Unhandled request")
            }
        }

        val dataSource = TodoDataSourceImpl(mockClient)
        val todos = dataSource.getTodos()

        assertEquals(2, todos.size)
        assertEquals("Todo 1", todos[0].title)
        assertEquals(false, todos[0].completed)
    }

    @Test
    fun `getTodo 성공 케이스`() = runBlocking {
        val mockClient = createMockClient { request ->
            if (request.url.encodedPath == "/todos/1") {
                respond(
                    content = """
                    {"id": 1, "title": "Todo 1", "completed": false}
                    """,
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                )
            } else {
                error("Unhandled request")
            }
        }

        val dataSource: TodoDataSource = TodoDataSourceImpl(mockClient)
        val todo = dataSource.getTodo(1)

        assertEquals(1, todo.id)
        assertEquals("Todo 1", todo.title)
        assertEquals(false, todo.completed)
    }

    @Test
    fun `네트워크 에러 케이스`() = runBlocking {
        val mockClient = createMockClient {
            throw ConnectTimeoutException("Connection timeout")
        }

        val dataSource: TodoDataSource = TodoDataSourceImpl(mockClient)

        try {
            dataSource.getTodos()
            fail("Expected exception not thrown")
        } catch (e: ConnectTimeoutException) {
            assertEquals("Connection timeout", e.message)
        }
    }

    @Test
    fun `존재하지 않는 ID 요청 케이스`() = runBlocking {
        val mockClient = createMockClient { request ->
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

        val dataSource: TodoDataSource = TodoDataSourceImpl(mockClient)

        try {
            dataSource.getTodo(0)
            fail("Expected exception not thrown")
        } catch (e: IllegalArgumentException) {
            assertEquals("Todo with ID 0 not found", e.message)
        }
    }
}