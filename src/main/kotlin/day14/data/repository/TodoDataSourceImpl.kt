package org.example.day14.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.data.model.Todo
import org.example.day14.data.resources.todoJsonString
import org.example.day14.data.resources.todosJsonString
import org.example.day14.util.fetchData
import org.example.day14.util.jsonConfig

class TodoDataSourceImpl : TodoDataSource {
    private val url = "https://jsonplaceholder.typicode.com/todos"

    override suspend fun getTodo(): Todo {
        return jsonConfig.decodeFromString(todoJsonString)
    }

    override suspend fun getTodos(): List<Todo> {
        return jsonConfig.decodeFromString(todosJsonString)
    }

    override suspend fun getTodo(id: Int): Flow<Todo> = flow {
        emit(fetchData<Todo>("$url/$id"))
    }

    override suspend fun getTodosFromUrl(): Flow<List<Todo>> = flow {
        emit(fetchData<List<Todo>>(url))
    }
}