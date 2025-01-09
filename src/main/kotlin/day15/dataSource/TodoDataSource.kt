package day15.dataSource

import day15.model.Todo

interface TodoDataSource {
    suspend fun todoData(): List<Todo>
}