package day15.repository

import day15.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}

