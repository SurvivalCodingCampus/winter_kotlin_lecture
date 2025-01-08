package org.example.day15.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day15.data.datasource.PostDataSource
import org.example.day15.data.model.Post

class PostRepositoryImpl(
    private val postDataSource: PostDataSource,
) : PostRepository {
    override suspend fun getPost(id: Int): Flow<Post> =
        postDataSource.getPost(id)

    override suspend fun getPosts(page: Int): Flow<List<Post>> =
        postDataSource.getPosts(page)

    override suspend fun getPosts(page: Int, limit: Int): Flow<List<Post>> =
        postDataSource.getPosts(page, limit)
}