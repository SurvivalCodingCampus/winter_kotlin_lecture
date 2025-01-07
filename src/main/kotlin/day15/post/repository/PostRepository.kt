package org.hyunjung.day15.post.repository

import org.hyunjung.day15.post.model.Post

interface PostRepository {
    suspend fun getPost(id: Int): Post
    suspend fun getPosts(page: Int = 1, limit: Int? = null): List<Post>
}