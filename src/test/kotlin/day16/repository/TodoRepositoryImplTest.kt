package day16.repository

import day16.data_source.TodoDataSource
import day16.data_source.TodoDataSourceImpl
import day16.model.Todo
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.utils.io.ByteReadChannel
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import io.ktor.http.*
import io.ktor.client.HttpClient

class TodoRepositoryImplTest {
    private val mockEngine = MockEngine { request ->
        when (request.url.toString()) {
            "https://jsonplaceholder.typicode.com/todos" -> {
                respond(
                    content = ByteReadChannel(
                        """
                        [
                            {"userId": 1, "id": 1, "title": "Todo 1", "completed": false},
                            {"userId": 1, "id": 2, "title": "Todo 2", "completed": true}
                        ]
                        """.trimIndent().toByteArray()
                    ),
                    status = HttpStatusCode.OK,
                    headers = headersOf("Content-Type", "application/json")
                )
            }

            "https://jsonplaceholder.typicode.com/todos/1" -> {
                respond(
                    content = ByteReadChannel(
                        """
                        {"userId": 1, "id": 1, "title": "Todo 1", "completed": false}
                        """.trimIndent().toByteArray()
                    ),
                    status = HttpStatusCode.OK,
                    headers = headersOf("Content-Type", "application/json")
                )
            }
            else -> {
                respond(
                    content = ByteReadChannel("Not Found"),
                    status = HttpStatusCode.NotFound
                )
            }
        }
    }

    // MockEngine을 사용하여 HttpClient를 생성
    private val mockHttpClient = HttpClient(mockEngine)
    private val todoDataSource: TodoDataSource = TodoDataSourceImpl(mockHttpClient)  // Mock 엔진을 사용하는 데이터 소스
    private val todoRepository = TodoRepositoryImpl(todoDataSource)

    @Test
    fun `getTodos 성공 케이스`() = runTest {
        val expectedTodos = listOf(
            Todo(1, 1, "Todo 1", false),
            Todo(1, 2, "Todo 2", true)
        )

        val todos = todoRepository.getTodos()
        assertEquals(expectedTodos, todos)
    }

    @Test
    fun `getTodo 성공 케이스`() = runTest {
        val expectedTodo = Todo(1, 1, "Todo 1", false)

        val todo = todoRepository.getTodo(1)
        assertEquals(expectedTodo, todo)
    }

    @Test
    fun `네트워크 에러 케이스`() = runTest {
        // Todo
    }


    @Test
    fun `존재하지 않는 ID 요청 케이스`() = runTest {
        assertFailsWith<IllegalStateException> {
            todoRepository.getTodo(999)
        }
    }

}