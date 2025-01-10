package org.example.day16.repository_exam.repository.todo

import org.example.day16.repository_exam.model.todo.Todo


interface TodoRepository {
    suspend fun getTodos(): List<Todo>

    suspend fun getCompletedTodos(): List<Todo>
}