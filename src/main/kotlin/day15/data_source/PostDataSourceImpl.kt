package day15.data_source

import day15.model.Post
import day15.util.JsonData
import kotlinx.serialization.json.Json

class PostDataSourceImpl: PostDataSource {
    override suspend fun postData(): List<Post> {
        return Json.decodeFromString<List<Post>>(JsonData.POST_DATA)
    }
}