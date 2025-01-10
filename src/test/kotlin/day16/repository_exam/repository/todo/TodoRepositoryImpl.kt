package day16.repository_exam.repository.todo

import org.example.day16.repository_exam.data_source.todo.TodoDatasource
import org.example.day16.repository_exam.model.todo.Todo
import org.example.day16.repository_exam.repository.todo.TodoRepository


class TodoRepositoryImpl(private val datasource: TodoDatasource): TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return datasource.getAllTodos()
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return datasource.getAllTodos().filter { it.completed }
    }
}