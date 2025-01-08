package org.example.day14.data.mock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.data.datasource.TodoDataSource
import org.example.day14.data.model.Todo
import org.example.day14.data.resources.todosJsonString
import org.example.day14.util.jsonConfig

class MockTodoDataSourceImpl : TodoDataSource {
    private val todos = jsonConfig.decodeFromString<List<Todo>>(todosJsonString)
    override suspend fun getTodo(id: Int): Flow<Todo> = flow {
        emit(todos.first { it.id == id })
    }

    override suspend fun getTodos(): Flow<List<Todo>> = flow {
        emit(todos)
    }

    override suspend fun getCompletedTodos(): Flow<List<Todo>> = flow {
        emit(todos.filter { it.completed })
    }
}