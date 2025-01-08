package day15.data

import day14.Data
import day15.models.Post
import kotlinx.serialization.json.Json

class MockPostDataSource : PostDataSource {
    override suspend fun getPosts(): List<Post> = Json.decodeFromString(Data.POSTS_STRING)
}