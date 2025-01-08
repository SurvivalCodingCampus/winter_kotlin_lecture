package day15

import day14.Todo
import day14.TodoDataSource

class TodoRepositoryImpl(private val source: TodoDataSource) : TodoRepository {
    override suspend fun getAll(): List<Todo> = source.getTodos()
    override suspend fun getCompleted(): List<Todo> = source.getTodos().filter { it.completed }
}