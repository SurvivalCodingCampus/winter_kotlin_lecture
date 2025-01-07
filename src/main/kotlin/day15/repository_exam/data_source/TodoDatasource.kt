package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.Todo

interface TodoDatasource {
    fun getTodo(userId: Int): Todo?
    fun saveTodo(todo: Todo)
    fun getAllTodos(): List<Todo>
}