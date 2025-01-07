package day15.repository

import day15.data_source.TodoDataSource
import day15.model.Todo

class TodoRepositoryImpl(private val dataSource: TodoDataSource):TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return dataSource.getTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return dataSource.getCompletedTodos()
    }
}

