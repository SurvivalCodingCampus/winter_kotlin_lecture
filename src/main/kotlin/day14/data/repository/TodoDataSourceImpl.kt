package org.example.day14.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.example.day14.data.model.Todo
import org.example.day14.data.resources.todoJsonString
import org.example.day14.data.resources.todosJsonString
import java.net.HttpURLConnection
import java.net.URL

class TodoDataSourceImpl : TodoDataSource {
    @OptIn(ExperimentalSerializationApi::class)
    private val jsonConfig = Json {
        allowTrailingComma = true
        ignoreUnknownKeys = true
    }

    private suspend inline fun <reified T> fetchData(url: String): T {
        val httpUrlConnection = withContext(Dispatchers.IO) {
            URL(url).openConnection() as HttpURLConnection
        }

        val data = try {
            httpUrlConnection.requestMethod = "GET"
            httpUrlConnection.inputStream.bufferedReader().use { it.readText() }
        } finally {
            httpUrlConnection.disconnect()
        }

        return jsonConfig.decodeFromString(data)
    }


    override suspend fun getTodo(): Todo {
        return jsonConfig.decodeFromString(todoJsonString)
    }

    override suspend fun getTodos(): List<Todo> {
        return jsonConfig.decodeFromString(todosJsonString)
    }

    override suspend fun getTodo(url: String, id: Int): Flow<Todo> = flow {
        emit(fetchData<Todo>("$url/$id"))
    }

    override suspend fun getTodos(url: String): Flow<List<Todo>> = flow {
        emit(fetchData<List<Todo>>(url))
    }
}