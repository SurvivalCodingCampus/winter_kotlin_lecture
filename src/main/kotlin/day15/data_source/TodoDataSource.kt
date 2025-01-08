package org.example.day15.data_source

import kotlinx.serialization.json.Json
import org.example.day15.JsonData.TODO_JSON
import org.example.day15.model.Todo

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
}

class TodoDataSourceImpl: TodoDataSource {
    override suspend fun getTodos(): List<Todo> {
        return Json.decodeFromString(TODO_JSON)
    }
}