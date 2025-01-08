package org.hyunjung.day15.todo.repository

import org.hyunjung.day15.todo.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}