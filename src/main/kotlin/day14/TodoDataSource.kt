package day14

import day12.CollectionChartDataList
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

/*
과제1. 간단한 JSON 을 데이터 클래스로 변환
과제2. Json List 를 List<To do>로 변환
*/


@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

interface TodoDataSource {
    suspend fun getTodo(): List<Todo>
}


class TodoDataSourceImpl : TodoDataSource {
    val jsonString = File("JsonList.txt").readText()
    val jsonList = Json.decodeFromString<List<Todo>>(jsonString)

    override suspend fun getTodo(): List<Todo> {
        return jsonList
    }
}

