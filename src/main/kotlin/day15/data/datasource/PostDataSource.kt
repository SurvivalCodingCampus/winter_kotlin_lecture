package org.example.day15.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.util.fetchData
import org.example.day15.data.model.Post

interface PostDataSource {
    suspend fun getPost(id: Int): Flow<Post>
    suspend fun getPosts(page: Int): Flow<List<Post>>
    suspend fun getPosts(page: Int, limit: Int): Flow<List<Post>>
}