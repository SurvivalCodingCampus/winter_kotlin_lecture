import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import org.example.day15.Model.Todo
import org.example.day15.Utils.format

class TodoDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
) : TodoDataSource {
    override suspend fun getTodos(): List<Todo> {
        val response = client.get("https://jsonplaceholder.typicode.com/todos")
        return Json.decodeFromString<List<Todo>>(response.bodyAsText())
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        TODO("Not yet implemented")
    }

    override suspend fun getTodo(id: Int): Todo {
        val response = client.get("httpsj://jsonplaceholder.typicode.com/todos/$id")
        return format.decodeFromString(response.bodyAsText())
    }
}