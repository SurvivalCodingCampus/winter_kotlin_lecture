package org.example.day16.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day16.data.datasource.TodoDataSource
import org.example.day16.data.model.Todo

class TodoRepositoryImpl(
    private val todoDataSource: TodoDataSource
) : TodoRepository {
    override suspend fun getTodo(id: Int): Flow<Todo> =
        todoDataSource.getTodo(id)

    override suspend fun getTodos(): Flow<List<Todo>> =
        todoDataSource.getTodos()
}