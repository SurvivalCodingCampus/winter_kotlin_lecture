package day15

import day14.Todo

interface TodoRepository {
    suspend fun getAll(): List<Todo>
    suspend fun getCompleted(): List<Todo>
}