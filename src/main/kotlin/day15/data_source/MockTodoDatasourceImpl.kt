package day15.data_source

import day15.model.Todo
import kotlinx.serialization.json.Json
import java.io.File

class MockTodoDatasourceImpl : TodoDataSource {
    override fun getTodos(): List<Todo> {
        return json
    }

    override fun getCompletedTodos(): List<Todo> {
        return json.filter { it.completed }
    }

    private val json = Json.decodeFromString<List<Todo>>(File("JsonList.txt").readText())
}