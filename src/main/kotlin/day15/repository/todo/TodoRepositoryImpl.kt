package org.example.day15.repository.todo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import org.example.day14.todo.Todo
import org.example.day15.data_source.todo.TodoDataSource

class TodoRepositoryImpl(override val dataSource: TodoDataSource) : TodoRepository {
    override suspend fun getTodos(): List<Todo> = withContext(Dispatchers.IO) {
        try {
            dataSource.getTodos()
        } catch (e: Exception) {
            when (e) {
                is SerializationException -> throw e
                else -> emptyList()
            }
        }
    }

    override suspend fun getCompletedTodos(): List<Todo> = withContext(Dispatchers.IO) {
        try {
            dataSource.getTodos().filter { it.completed }
        } catch (e: Exception) {
            when (e) {
                is SerializationException -> throw e
                else -> emptyList()
            }
        }
    }

}