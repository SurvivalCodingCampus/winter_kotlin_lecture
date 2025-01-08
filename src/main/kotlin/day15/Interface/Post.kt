package org.example.day15.Interface

import org.example.day15.Model.Post

interface PostRepositoryImpl {
    suspend fun getPost(id: Int): Post?
    suspend fun getPosts(page: Int = 1, limit: Int? = null): List<Post?>
}

interface PostDataSource {
    val posts: List<Post?>
}

