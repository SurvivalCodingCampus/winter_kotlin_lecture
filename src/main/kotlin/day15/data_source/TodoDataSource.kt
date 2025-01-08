package day15.data_source

import day15.model.Todo

interface TodoDataSource {
    suspend fun todoData(): List<Todo>
}