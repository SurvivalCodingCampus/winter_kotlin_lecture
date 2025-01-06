package org.example.day14.todo

import fuel.get
import kotlinx.io.readString
import kotlinx.serialization.json.Json

class TodoHttpRepositoryImpl : TodoHttpRepository {


    override suspend fun getTodo(id: Int): Todo {
        return runCatching {
            val data = Json.decodeFromString<TodoData>(fuelClient.get("$baseUrl/${id.toString()}").source.readString())
            return Todo.fromDataWithDefault(data)
        }.getOrElse {
            throw it
        }
    }

    override suspend fun getTodos(): List<Todo> {
        val data = Json.decodeFromString<List<TodoData>>(fuelClient.get(baseUrl).source.readString())
        val filteredData = filterNullData(data)
        return filteredData.map { Todo.fromDataWithDefault(it) }
    }


    private fun filterNullData(data: List<TodoData>): List<TodoData> {
        return data.filter { data -> data.id != null || data.userId != null || data.title != null || data.completed != null }
    }

}