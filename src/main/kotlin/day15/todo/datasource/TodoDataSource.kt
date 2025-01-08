package org.hyunjung.day15.todo.datasource

import org.hyunjung.day15.todo.model.Todo

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}