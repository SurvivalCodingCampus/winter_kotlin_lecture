package day15.data_source

import day15.model.Post

interface PostDataSource {
    fun getPost(id: Int) : Post
    fun getPosts(page: Int = 1, limit: Int? = null) : List<Post>
}