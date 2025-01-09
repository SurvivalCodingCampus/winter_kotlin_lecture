package day16.data_source

import day16.model.Todo

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
    suspend fun getTodo(id: Int): Todo
}