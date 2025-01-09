package org.hyunjung.day16.mocking.repository

import org.hyunjung.day16.mocking.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getTodo(id: Int): Todo
}