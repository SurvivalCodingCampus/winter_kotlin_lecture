package day16

import day14.practice_problem_01.Todo
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

fun Todo.Companion.fromJson(data: String): Todo {
    return Json.decodeFromString<Todo>(data)
}

interface TodoDataSource {
    suspend fun getTodo(id: Int): Todo
    suspend fun getTodos(): List<Todo>
}

class TodoDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
): TodoDataSource {
    override suspend fun getTodo(id: Int): Todo {
        val response = client.get("https://jsonplaceholder.typicode.com/todos/$id")
        return Todo.fromJson(response.bodyAsText())
    }

    override suspend fun getTodos(): List<Todo> {
        val response = client.get("https://jsonplaceholder.typicode.com/todos")
        return Json.decodeFromString<List<Todo>>(response.bodyAsText())
    }
}

class MockTodoDataSourceImpl: TodoDataSource {
    val mockEngine = MockEngine { request ->
        when(request.url.toString()) {
            "https://jsonplaceholder.typicode.com/todos/1" -> {
                respond(
                    content = HttpClient(CIO).get(request.url).bodyAsText(),
                    status = HttpStatusCode.OK,
                    headers = headersOf("Data of Todo", "Todo Data")
                )
            }
            "https://jsonplaceholder.typicode.com/todos" -> {
                respond(
                    content = HttpClient(CIO).get(request.url).bodyAsText(),
                    status = HttpStatusCode.OK,
                    headers = headersOf("Data of Todos", "Todos Data")
                )
            }
            "test-network-error" -> {
                respond(
                    content = "network error",
                    status = HttpStatusCode.NotFound
                )
            }
            else -> {
                respond(
                    content = "error",
                    status = HttpStatusCode.NotFound
                )
            }
        }
    }

    override suspend fun getTodo(id: Int): Todo {
        val dataStatus = HttpClient(mockEngine).get("https://jsonplaceholder.typicode.com/todos/$id")
        // ClientRequestException가 4xx 예외를 못 잡아준다.
//        try {
//            data = HttpClient(mockEngine).get("https://jsonplaceholder.typicode.com/todos/$id").bodyAsText()
//            println("try")
//        } catch(e: ClientRequestException) {
//            data = HttpClient(mockEngine).get("https://jsonplaceholder.typicode.com/todos/1").bodyAsText()
//            println("catch")
//        }
        var data: String = ""
        return if(dataStatus.status == HttpStatusCode.NotFound)
            throw IllegalArgumentException()
        else Todo.fromJson(HttpClient(mockEngine).get("https://jsonplaceholder.typicode.com/todos/$id").bodyAsText())

    }

    override suspend fun getTodos(): List<Todo> {
        return Json.decodeFromString<List<Todo>>(HttpClient(mockEngine).get("https://jsonplaceholder.typicode.com/todos").bodyAsText())
    }
}

interface TodoRepository {
    suspend fun getTodo(id: Int): Todo
    suspend fun getTodos(): List<Todo>
}

class MockTodoRepositoryImpl(private val dataSource: TodoDataSource): TodoRepository {
    override suspend fun getTodo(id: Int): Todo {
        return dataSource.getTodo(id)
    }

    override suspend fun getTodos(): List<Todo> {
        return dataSource.getTodos()
    }
}