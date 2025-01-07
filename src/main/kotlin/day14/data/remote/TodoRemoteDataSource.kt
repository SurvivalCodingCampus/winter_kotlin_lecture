package org.example.day14.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.data.datasource.TodoDataSource
import org.example.day14.data.model.Todo
import org.example.day14.util.fetchData
import org.example.day15.data.resource.BASE_URL

class TodoRemoteDataSource : TodoDataSource {
    override suspend fun getTodo(id: Int): Flow<Todo> = flow {
        emit(fetchData<Todo>("$BASE_URL/$id"))
    }

    override suspend fun getTodos(): Flow<List<Todo>> = flow {
        emit(fetchData<List<Todo>>(BASE_URL))
    }

    override suspend fun getCompletedTodos(): Flow<List<Todo>> = flow {
        emit(fetchData<List<Todo>>("$BASE_URL?completed=false"))
    }
}