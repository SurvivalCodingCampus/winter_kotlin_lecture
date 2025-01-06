package day14

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/*
과제1. 간단한 JSON 을 데이터 클래스로 변환
*/

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
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
