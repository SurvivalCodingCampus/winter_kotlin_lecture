package org.example.day15.data_source.todo

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.example.day14.todo.Todo
import org.example.day15.data_source.KtorClient

class KtorTodoDataSourceImpl(override val baseUrl: String, override val client: HttpClient = HttpClient(CIO)) :
    TodoDataSource, KtorClient {
    override suspend fun getTodos(): List<Todo> = withContext(Dispatchers.IO) {
        try {
            val response = client.get(baseUrl)
            defaultJson.decodeFromString(response.bodyAsText())
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getTodo(id: Int): Todo = withContext(Dispatchers.IO) {
        try {
            getTodos().first { it.id == id }
        } catch (e: Exception) {
            throw e
        }
    }
}