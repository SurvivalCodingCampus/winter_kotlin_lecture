package day15.dataSource

import day15.model.Post

interface PostDataSource {
    suspend fun postData(): List<Post>
}