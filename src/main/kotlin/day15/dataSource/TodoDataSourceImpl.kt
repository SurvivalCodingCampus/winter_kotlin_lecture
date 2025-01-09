package day15.dataSource

import day15.model.Todo
import day15.util.JsonData
import kotlinx.serialization.json.Json

class TodoDataSourceImpl: TodoDataSource {
    override suspend fun todoData(): List<Todo> {
        return Json.decodeFromString<List<Todo>>(JsonData.TODO_DATA)
    }
}