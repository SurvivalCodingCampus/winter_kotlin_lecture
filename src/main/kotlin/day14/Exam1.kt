package org.example.day14

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


interface TodoDataSource {
    suspend fun getTodo(): Todo
}

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

class TodoDataSourceImpl : TodoDataSource {
    private val json = """
    {
      "userId": 1,
      "id": 1,
      "title": "delectus aut autem",
      "completed": false
    }
""".trimIndent()

    override suspend fun getTodo(): Todo {

        return Json.decodeFromString(json)
    }
}

fun main() = runBlocking {
    val todoDataSourceImpl = TodoDataSourceImpl()
    println(todoDataSourceImpl.getTodo())
}