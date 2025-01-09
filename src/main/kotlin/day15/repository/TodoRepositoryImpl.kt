package day15.repository

import day15.dataSource.TodoDataSource
import day15.model.Todo

class TodoRepositoryImpl(private val dataSource: TodoDataSource): TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return dataSource.todoData()
    }
    override suspend fun getCompletedTodos(): List<Todo> {
        val jsonList = getTodos()
        return jsonList.filter { it.completed }
    }
}
