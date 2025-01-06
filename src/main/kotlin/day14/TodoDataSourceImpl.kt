package day14

import kotlinx.serialization.json.Json

class TodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodo(): Todo {
        return Json.decodeFromString<Todo>(Data.todo1String)
    }
}