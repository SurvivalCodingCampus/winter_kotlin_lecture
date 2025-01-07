package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.Post

interface PostDatasource {
    fun getPost(id: Int): Post
    fun savePost(post: Post)
    fun getAllPosts(): List<Post>
}