package org.example.day15.repository

import org.example.day15.data_source.PostDataSource
import org.example.day15.model.Post

interface PostRepository {
    suspend fun getPost(id: Int): Post
    suspend fun getPosts(page: Int = 1, limit: Int? = null): List<Post>
}

class PostRepositoryImpl(private val dataSource: PostDataSource) : PostRepository {
    override suspend fun getPost(id: Int): Post {
        return dataSource.getPost(id).first { it.id == id }
    }

    override suspend fun getPosts(page: Int, limit: Int?): List<Post> {
        val allPosts = dataSource.getPost()
        val safePage = if (page < 1) 1 else page
        val offset = (safePage - 1) * (limit ?: allPosts.size)
        return allPosts.drop(offset).take(limit ?: allPosts.size)
    }
}