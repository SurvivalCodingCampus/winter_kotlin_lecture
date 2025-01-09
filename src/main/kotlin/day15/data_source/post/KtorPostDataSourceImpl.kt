package org.example.day15.data_source.post

import io.ktor.client.request.*
import io.ktor.client.statement.*
import org.example.day15.data_source.KtorClient
import org.example.day15.model.Post

class KtorPostDataSourceImpl(override val baseUrl: String) : PostDataSource, KtorClient {

    override suspend fun getPosts(): List<Post> {
        try {
            val response = client.get(baseUrl)
            return defaultJson.decodeFromString<List<Post>>(response.bodyAsText())
        } catch (e: Exception) {
            throw e
        }
    }
}