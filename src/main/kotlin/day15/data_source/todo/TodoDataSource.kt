package org.example.day15.data_source.todo

import org.example.day14.todo.Todo
import org.example.day15.data_source.DataSource

interface TodoDataSource : DataSource {
    suspend fun getTodos(): List<Todo>
}