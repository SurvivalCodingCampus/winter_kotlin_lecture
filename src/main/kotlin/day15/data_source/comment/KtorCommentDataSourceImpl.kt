package org.example.day15.data_source.comment

import io.ktor.client.request.*
import io.ktor.client.statement.*
import org.example.day15.data_source.KtorClient
import org.example.day15.model.Comment

class KtorCommentDataSourceImpl(override val baseUrl: String) : CommentDataSource, KtorClient {
    override suspend fun getComments(): List<Comment> {
        try {
            val response = client.get(baseUrl)
            return defaultJson.decodeFromString<List<Comment>>(response.bodyAsText())
        } catch (e: Exception) {
            throw e
        }
    }
}