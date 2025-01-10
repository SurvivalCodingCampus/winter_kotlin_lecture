package org.example.day16.repository_exam.data_source.todo

import org.example.day16.repository_exam.model.todo.Todo

interface TodoDatasource {
    suspend fun getTodo(id: Int): Todo?
    suspend fun saveTodo(todo: Todo)
    suspend fun getAllTodos(): List<Todo>
}