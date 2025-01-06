package day14

import kotlinx.serialization.json.Json

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodos(): List<Todo> {
        return Json.decodeFromString<List<Todo>>(Data.TODO_STRING)
    }
}