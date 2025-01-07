package org.hyunjung.day15.todo.repository

import org.hyunjung.day15.todo.datasource.TodoDataSource
import org.hyunjung.day15.todo.model.Todo

class TodoRepositoryImpl(
    private val todoDataSource: TodoDataSource
) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return todoDataSource.getTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return todoDataSource.getCompletedTodos()
    }
}