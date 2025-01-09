package day15.data_source

import day15.model.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.File

class MockTodoDatasourceImpl : TodoDataSource {
    override suspend fun getTodos(): List<Todo> = withContext(Dispatchers.IO) {
        json
    }

    override suspend fun getCompletedTodos(): List<Todo> = withContext(Dispatchers.IO) {
        json.filter { it.completed }
    }

    private val json: List<Todo> by lazy {
        try {
            val file = File("JsonList.txt")
            Json.decodeFromString(file.readText())
        } catch (e: Exception) {
            // 로깅 추가
            emptyList()
        }
    }
}