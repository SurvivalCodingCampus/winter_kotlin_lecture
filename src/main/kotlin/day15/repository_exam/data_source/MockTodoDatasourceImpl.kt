package org.example.day15.repository_exam.data_source

import kotlinx.serialization.json.Json
import org.example.day15.repository_exam.model.Todo
import java.io.File

class MockTodoDatasourceImpl : TodoDatasource{
    private val filePath = "todos.txt"
    private val file = File(filePath)

    override suspend fun getTodo(userId: Int): Todo? {
        TODO("Not yet implemented")
    }

    override suspend fun saveTodo(todo: Todo) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTodos(): List<Todo> {
        return Json.decodeFromString<List<Todo>>(file.readText())
    }
}