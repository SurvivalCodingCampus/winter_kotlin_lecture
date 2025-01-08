package org.hyunjung.day16.mocking.datasource

import org.hyunjung.day16.mocking.model.Todo

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
    suspend fun getTodo(id: Int): Todo
}