package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.data_source.TodoDatasource
import org.example.day15.repository_exam.model.Todo

class TodoRepositoryImpl(private val datasource: TodoDatasource): TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return datasource.getAllTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return datasource.getAllTodos().filter { it.completed }
    }
}