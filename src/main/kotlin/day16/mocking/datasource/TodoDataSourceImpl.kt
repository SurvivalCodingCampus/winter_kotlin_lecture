package org.hyunjung.day16.mocking.datasource

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.hyunjung.day16.mocking.model.Todo
import org.hyunjung.day16.mocking.util.Constants

class TodoDataSourceImpl(
    private val client: HttpClient
) : TodoDataSource {

    override suspend fun getTodos(): List<Todo> {
        val url = "${Constants.BASE_URL}/todos"
        return client.get(url).body()
    }

    override suspend fun getTodo(id: Int): Todo {
        val todo: Todo = client.get("${Constants.BASE_URL}/todos/$id").body()

        if (todo.id <= 0 || todo.title.isBlank()) {
            throw IllegalArgumentException("Todo with ID $id not found")
        }

        return todo
    }
}