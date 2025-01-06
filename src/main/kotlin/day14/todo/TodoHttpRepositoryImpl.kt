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
            return Todo.fromData(data)
        }.getOrElse {
            throw it
        }
    }

}