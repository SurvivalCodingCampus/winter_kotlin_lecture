package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.model.Post

interface PostRepository {
    suspend fun getPost(id: Int): Post
    suspend fun getPosts(page: Int = 1, limit: Int? = null): List<Post>
}