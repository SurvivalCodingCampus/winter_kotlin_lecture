package org.example.day15.repository.post

import org.example.day15.data_source.post.PostDataSource
import org.example.day15.model.Post

interface PostRepository {
    val dataSource: PostDataSource
    suspend fun getPost(id: Int): Post

    suspend fun getPosts(page: Int = 1, limit: Int? = null): List<Post>
}