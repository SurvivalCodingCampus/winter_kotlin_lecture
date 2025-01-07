package day14

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


val json = """{
    "userId": 1,
    "id": 1,
    "title": "delectus aut autem",
    "completed": false
}
"""


@Serializable
data class Todo(val userId: Int, val id: Int, val title: String, val completed: Boolean) {}

interface TodoDataSource {
    suspend fun getTodo(jsonData: String): Todo

}

class TodoManger : TodoDataSource {
    override suspend fun getTodo(jsonData: String): Todo {
        return Json.decodeFromString<Todo>(jsonData)
    }
}

fun main() = runBlocking {

    val result = TodoManger().getTodo(json)
    println(result)
}
