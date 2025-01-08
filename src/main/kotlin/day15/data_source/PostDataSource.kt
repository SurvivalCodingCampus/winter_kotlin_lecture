package org.example.day15.data_source

import kotlinx.serialization.json.Json
import org.example.day15.JsonData.POST_JSON
import org.example.day15.model.Post

interface PostDataSource {
    suspend fun getPost(id: Int? = null): List<Post>
}

class PostDataSourceImpl : PostDataSource {
    override suspend fun getPost(id: Int?): List<Post> {
        return Json.decodeFromString(POST_JSON)
    }
}