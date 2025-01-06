package org.example.day14.todo

import fuel.Fuel
import fuel.get
import kotlinx.io.readString
import kotlinx.serialization.json.Json

class TodoHttpRepositoryImpl : TodoHttpRepository {
    override val baseUrl: String = "https://jsonplaceholder.typicode.com/todos"

    override suspend fun getTodo(id: Int): Todo {
        return runCatching {
            val data = Json.decodeFromString<TodoData>(Fuel.get("$baseUrl/${id.toString()}").source.readString())
            return Todo.fromDataWithDefault(data)
        }.getOrElse {
            throw it
        }
    }

    override suspend fun getTodos(): List<Todo> {
        val data = Json.decodeFromString<List<TodoData>>(Fuel.get(baseUrl).source.readString())
        val filteredData = filterNullData(data)
        return filteredData.map { Todo.fromDataWithDefault(it) }
    }


    private fun filterNullData(data: List<TodoData>): List<TodoData> {
        return data.filter { data -> data.id != null || data.userId != null || data.title != null || data.completed != null }
    }

}