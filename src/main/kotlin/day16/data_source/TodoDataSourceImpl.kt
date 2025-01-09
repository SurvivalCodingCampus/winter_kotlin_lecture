package day16.data_source

import day16.model.Todo
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.* import kotlinx.serialization.json.Json

class TodoDataSourceImpl(private val client: HttpClient = HttpClient(CIO)) : TodoDataSource {
    override suspend fun getTodos(): List<Todo> {
        val response = client.get("https://jsonplaceholder.typicode.com/todos")
        return try {
            Json.decodeFromString<List<Todo>>(response.bodyAsText())
        } catch (e: Exception) {
            throw IllegalStateException("사용자 데이터 파싱 중 오류 발생", e)
        }
    }

    override suspend fun getTodo(id: Int): Todo {
        val response = client.get("https://jsonplaceholder.typicode.com/todos/$id")
        return try {
            Json.decodeFromString(response.bodyAsText())
        } catch (e: Exception) {
            throw IllegalStateException("사용자 데이터 파싱 중 오류 발생", e)
        }
    }

}
