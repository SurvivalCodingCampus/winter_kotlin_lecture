package day14.practice_problem_01

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.coroutines.*

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
) {
    companion object {

    }
}

interface TodoDataSource {
    suspend fun getTodo(): Todo
}


class TodoDataSourceImpl: TodoDataSource {
    val data = """{
    "userId": 1,
    "id": 1,
    "title": "delectus aut autem",
    "completed": false
    }""".trimIndent()

    override suspend fun getTodo(): Todo {
        val getData = Json.decodeFromString<Todo>(data)
        return getData
    }
}

suspend fun main() {
    val todoData: Todo = TodoDataSourceImpl().getTodo()

    println("userId: ${todoData.userId}")
    println("id: ${todoData.id}")
    println("title: ${todoData.title}")
    println("completed: ${todoData.completed}")
}