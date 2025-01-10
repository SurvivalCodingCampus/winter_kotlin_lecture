package day15.data_source.post

import utils.network.ResponseResult
import utils.network.safeCall
import day15.model.Post
import day15.util.Urls
import kotlinx.serialization.json.Json

class MockPostDataSourceImpl : PostDataSource {

    // 전체 데이터
    override suspend fun getPosts(): ResponseResult<List<Post>> {
        return safeCall {
            Json.decodeFromString<List<Post>>(Urls.POST_DATA)
        }
    }
}