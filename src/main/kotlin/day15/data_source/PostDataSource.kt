package day15.data_source

import day15.model.Post

interface PostDataSource {
    suspend fun getPost(id: Int) : Post
    suspend fun getPosts(page: Int = 1, limit: Int? = null) : List<Post>
}