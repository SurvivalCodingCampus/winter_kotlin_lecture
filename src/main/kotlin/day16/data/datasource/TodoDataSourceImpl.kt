package org.example.day16.data.datasource

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.util.jsonConfig
import org.example.day15.data.resource.BASE_URL
import org.example.day16.data.model.Todo

class TodoDataSourceImpl(
    private val httpClient: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(jsonConfig)
        }
    }
) : TodoDataSource {
    override suspend fun getTodo(id: Int): Flow<Todo> = flow {
        emit(httpClient.get(BASE_URL) {
            url {
                appendPathSegments("/todos/${id}")
            }
        }.body<Todo>())
    }

    override suspend fun getTodos(): Flow<List<Todo>> = flow {
        emit(httpClient.get("$BASE_URL/todos").body<List<Todo>>())
    }
}