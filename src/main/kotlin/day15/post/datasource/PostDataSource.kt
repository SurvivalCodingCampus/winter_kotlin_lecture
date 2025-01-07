package org.hyunjung.day15.post.datasource

import org.hyunjung.day15.post.model.Post

interface PostDataSource {
    suspend fun getPost(id: Int): Post
    suspend fun getPosts(): List<Post>
}