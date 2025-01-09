package org.hyunjung.day16.mocking.repository

import org.hyunjung.day16.mocking.datasource.TodoDataSource
import org.hyunjung.day16.mocking.model.Todo

class TodoRepositoryImpl(
    private val todoDataSource: TodoDataSource
) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return todoDataSource.getTodos()
    }

    override suspend fun getTodo(id: Int): Todo {
        return todoDataSource.getTodo(id)
    }
}