package org.example.day16.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day16.data.model.Todo

interface TodoRepository {
    suspend fun getTodo(id: Int): Flow<Todo>
    suspend fun getTodos(): Flow<List<Todo>>
}