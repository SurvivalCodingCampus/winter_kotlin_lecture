package org.example.day16.repository.todo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.example.day14.todo.Todo
import org.example.day15.data_source.todo.TodoDataSource
import org.example.day15.repository.todo.TodoRepository

class KtorTodoRepositoryImpl(override val dataSource: TodoDataSource) : TodoRepository {
    override suspend fun getTodo(id: Int): Todo = withContext(Dispatchers.IO) {
        try {
            dataSource.getTodo(id)
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getTodos(): List<Todo> = withContext(Dispatchers.IO) {
        try {
            dataSource.getTodos()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getCompletedTodos(): List<Todo> = withContext(Dispatchers.IO) {
        try {
            getTodos().filter { it.completed }
        } catch (e: Exception) {
            throw e
        }
    }

}