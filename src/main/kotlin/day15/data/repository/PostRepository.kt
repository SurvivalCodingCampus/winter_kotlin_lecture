package org.example.day15.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day15.data.model.Post

interface PostRepository {
    suspend fun getPost(id: Int): Flow<Post>
    suspend fun getPosts(page: Int = 1): Flow<List<Post>>
    suspend fun getPosts(page: Int = 1, limit: Int): Flow<List<Post>>
}