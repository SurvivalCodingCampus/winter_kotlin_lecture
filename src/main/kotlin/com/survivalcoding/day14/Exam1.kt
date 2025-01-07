package com.survivalcoding.com.survivalcoding.day14

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
)

interface TodoDataSource {
    suspend fun getTodo(): Todo
}

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
