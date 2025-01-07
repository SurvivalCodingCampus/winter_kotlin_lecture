package day15.data

import day15.models.Post

interface PostDataSource {
    suspend fun getPosts(): List<Post>
}