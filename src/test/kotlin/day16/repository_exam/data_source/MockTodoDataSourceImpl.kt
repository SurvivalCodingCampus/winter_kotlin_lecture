package day16.repository_exam.data_source

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.day15.repository_exam.data_source.TodoDatasource
import org.example.day15.repository_exam.model.Todo

class MockTodoDataSourceImpl : TodoDatasource {
    val mockEngine = MockEngine { request ->
        when (request.url.toString()) {
            "https://test.com/todos" -> respond(
                content = """
                [
                    {"id": 1, "title": "Todo 1", "completed": false},
                    {"id": 2, "title": "Todo 2", "completed": true}
                    ]
            """,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )

            "https://test.com/todo" -> respond(
                content = """
                {"id": 1, "title": "Todo 1", "completed": false}
            """,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )

            else -> respond(
                content = """""",
                status = HttpStatusCode.NotFound,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
    }

    private val client: HttpClient = HttpClient(mockEngine)

    override suspend fun getTodo(userId: Int): Todo? {
        TODO("Not yet implemented")
    }

    override suspend fun saveTodo(todo: Todo) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTodos(): List<Todo> {
        return Json.decodeFromString<List<Todo>>(mockEngine.toString())
    }
}