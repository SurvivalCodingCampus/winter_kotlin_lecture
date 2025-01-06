package org.example.day14.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day14.data.model.Todo

interface TodoDataSource {
    suspend fun getTodo(): Todo
    suspend fun getTodo(url: String, id: Int): Flow<Todo>
    suspend fun getTodos(): List<Todo>
    suspend fun getTodos(url: String): Flow<List<Todo>>
}