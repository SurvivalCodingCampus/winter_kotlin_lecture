package org.example.day16.data.datasource

import kotlinx.coroutines.flow.Flow
import org.example.day16.data.model.Todo

interface TodoDataSource {
    suspend fun getTodo(id: Int): Flow<Todo>
    suspend fun getTodos(): Flow<List<Todo>>
}