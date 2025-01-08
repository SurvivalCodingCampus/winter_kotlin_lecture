package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.Todo

interface TodoDatasource {
    suspend fun getTodo(userId: Int): Todo?
    suspend fun saveTodo(todo: Todo)
    suspend fun getAllTodos(): List<Todo>
}