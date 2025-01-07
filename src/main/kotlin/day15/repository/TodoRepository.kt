package org.example.day15.repository

import org.example.day15.data_source.TodoDataSource
import org.example.day15.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}

class TodoRepositoryImpl(private val dataSource: TodoDataSource) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return dataSource.getTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return getTodos().filter { it.completed }
    }
}
