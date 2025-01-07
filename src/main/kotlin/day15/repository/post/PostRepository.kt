package day15.repository.post

import day15.model.Post

interface PostRepository {

    suspend fun getPost(id: Int): Post?

    suspend fun getPosts(page: Int = 1, limit: Int? = null): List<Post>

}