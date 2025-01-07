package day15.data_source

import day15.model.Todo

interface TodoDataSource {
    fun getTodos(): List<Todo>
    fun getCompletedTodos(): List<Todo>
}