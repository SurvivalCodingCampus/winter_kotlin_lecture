package day16.repository.todo

import io.kotest.common.runBlocking
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import org.example.day15.data_source.todo.KtorTodoDataSourceImpl
import org.example.day16.repository.todo.KtorTodoRepositoryImpl
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertTrue

class KtorTodoRepositoryImplTest {
    private val mockEngine = MockEngine { request ->
        when (request.url.toString()) {
            "https://test.com/todos/1" -> {
                respond(
                    """[{"id": 1, "title": "test", "completed": false}]""",
                    status = HttpStatusCode.OK,
                    headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                )
            }

            "https://test.com/todos/2" -> {
                respond(
                    content = "id is not found",
                    status = HttpStatusCode.NotFound,
                    headers = headersOf("Content-Type" to listOf(ContentType.Text.Plain.toString()))
                )
            }

            "https://test.com/todos" -> {
                respond("""[{"id": 1, "title": "test", "completed": false}]""")
            }

            else -> {
                respond("""[]""")
            }
        }

    }

    private fun setBaseUrl(prefix: String? = "") {
        baseUrl = "https://test.com/todos$prefix"
    }

    private var baseUrl = "https://test.com/todos/1"
    private val repository = KtorTodoRepositoryImpl(KtorTodoDataSourceImpl(baseUrl, HttpClient(mockEngine)))

    @Test
    fun getTodo(): Unit = runBlocking {
        val todo = repository.getTodo(1)
        assertTrue(todo.id == 1, "todo의 id 는 1 이여야 한다.")
        assertTrue(todo.title == "test", "todo의 title 은 test 이여야 한다.")
        assertTrue(todo.completed == false, "todo의 completed 는 false 이여야 한다.")
        setBaseUrl("/2")
        assertThrows<NoSuchElementException> { repository.getTodo(2) }
    }

    @Test
    fun getTodos() = runBlocking {
        setBaseUrl()
        val todos = repository.getTodos()
        assertTrue(todos.size == 1, "todos 의 크기는 1 이여야 한다.")
        assertTrue(todos[0].id == 1, "todos 의 첫번째 요소의 id 는 1 이여야 한다.")
        assertTrue(todos[0].title == "test", "todos 의 첫번째 요소의 title 은 test 이여야 한다.")
        assertTrue(todos[0].completed == false, "todos 의 첫번째 요소의 completed 는 false 이여야 한다.")
    }

    @Test
    fun getCompletedTodos() = runBlocking {
        setBaseUrl()
        val completedTodos = repository.getCompletedTodos()

        assertTrue(completedTodos.isEmpty(), "completedTodos 는 비어있어야 한다.")
    }

}