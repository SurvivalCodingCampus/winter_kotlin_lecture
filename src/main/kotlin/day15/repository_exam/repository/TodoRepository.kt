package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>

    suspend fun getCompletedTodos(): List<Todo>
}