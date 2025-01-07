package org.example.day15.data.mock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.util.jsonConfig
import org.example.day15.data.datasource.PostDataSource
import org.example.day15.data.model.Post
import org.example.day15.data.resource.postsData

class MockPostDataSourceImpl : PostDataSource {
    private val posts = jsonConfig.decodeFromString<List<Post>>(postsData)
    override suspend fun getPost(id: Int): Flow<Post> = flow {
        emit(posts.first { it.id == id })
    }

    override suspend fun getPosts(page: Int): Flow<List<Post>> = flow {
        val startIndex = (page.toPositive() - 1) * 10
        val endIndex = (startIndex + 10).coerceAtMost(posts.size)
        emit(posts.slice(startIndex..<endIndex))
    }

    override suspend fun getPosts(page: Int, limit: Int): Flow<List<Post>> = flow {
        val positivePage = page.toPositive()
        val positiveLimit = limit.toPositive()
        val startIndex = (positivePage - 1) * positiveLimit
        val endIndex = (startIndex + positiveLimit).coerceAtMost(posts.size)
        emit(posts.slice(startIndex..<endIndex))
    }
}

private fun Int.toPositive(): Int = if (this < 1) 1 else this