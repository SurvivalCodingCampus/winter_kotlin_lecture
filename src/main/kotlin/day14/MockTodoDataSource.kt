package day14

import kotlinx.serialization.json.Json

class MockTodoDataSource : TodoDataSource {
    override suspend fun getTodos(): List<Todo> = Json.decodeFromString(Data.TODO_STRING)
}