package org.example.day15.repository.todo

import org.example.day14.todo.Todo
import org.example.day15.data_source.todo.TodoDataSource

interface TodoRepository {
    val dataSource: TodoDataSource

    suspend fun getTodos(): List<Todo>

    suspend fun getCompletedTodos(): List<Todo>
}