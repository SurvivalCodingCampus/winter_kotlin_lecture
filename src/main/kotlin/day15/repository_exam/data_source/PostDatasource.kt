package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.Post

interface PostDatasource {
    suspend fun getPost(id: Int): Post
    suspend fun savePost(post: Post)
    suspend fun getAllPosts(): List<Post>
}