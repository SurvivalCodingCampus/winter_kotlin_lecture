package org.example.day14

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
)

interface TodoDataSource {
    suspend fun getTodo(): List<Todo>
}

class TodoDataSourceImpl : TodoDataSource {
//    private val json = """
//    {
//      "userId": 1,
//      "id": 1,
//      "title": "delectus aut autem",
//      "completed": false
//    }
//""".trimIndent()

    private val file = File("test_json2")
    private val json = file.readText()

    override suspend fun getTodo(): List<Todo> {
        return Json.decodeFromString(json)
    }
}

fun main() = runBlocking {
    val test = TodoDataSourceImpl()

    val job = launch {
        println(test.getTodo().toString())
    }

}