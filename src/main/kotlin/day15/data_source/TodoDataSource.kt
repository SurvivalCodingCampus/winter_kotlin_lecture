package day15.data_source

import day15.model.Todo

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}