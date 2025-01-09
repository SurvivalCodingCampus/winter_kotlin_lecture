package day16.repository

import day16.data_source.TodoDataSource
import day16.model.Todo

class TodoRepositoryImpl(private val dataSource:TodoDataSource): TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return try {
            dataSource.getTodos()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getTodo(id: Int): Todo {
        return try {
            dataSource.getTodo(id)
        } catch (e: Exception) {
            throw e
        }
    }
}