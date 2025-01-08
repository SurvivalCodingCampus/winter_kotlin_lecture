package day15.data_source

import day15.model.Post

interface PostDataSource {
    suspend fun postData(): List<Post>
}