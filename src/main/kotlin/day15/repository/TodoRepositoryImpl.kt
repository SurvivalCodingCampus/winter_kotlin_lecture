package day15.repository

import day15.data_source.TodoDataSource
import day15.model.Todo
import kotlinx.serialization.json.Json
import java.io.File

class TodoRepositoryImpl(private val dataSource: TodoDataSource): TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return dataSource.todoData()
    }
    override suspend fun getCompletedTodos(): List<Todo> {
        val jsonList = getTodos()
        return jsonList.filter { it.completed }
    }
}
