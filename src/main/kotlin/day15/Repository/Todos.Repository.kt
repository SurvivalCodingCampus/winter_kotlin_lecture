package org.example.day15.Repository

import TodoDataSource
import TodoRepositoryImpl
import org.example.day15.Model.Todo
import org.example.day15.Utils.parseJson


open class TodoDataSourceImp(private val jsonFilePath: String) : TodoDataSource, TodoRepositoryImpl {
    override var todo: List<Todo>
        get() = parseJson(jsonFilePath)
        set(value) {}

    override suspend fun getTodos(): List<Todo> {
        if (todo.isEmpty()) emptyList<String?>()
        return todo
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        if (todo.isEmpty()) emptyList<String?>()
        return todo.filter { todo -> todo.completed }
    }

}


const val todoDataSource = "./src/main/kotlin/day15/RawData/todos.json"

class TodoRepository : TodoDataSourceImp(todoDataSource) {
}

