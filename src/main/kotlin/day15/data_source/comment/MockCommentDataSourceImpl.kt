package day15.data_source.comment

import utils.network.ResponseResult
import utils.network.safeCall
import day15.model.Comment
import day15.util.Urls
import kotlinx.serialization.json.Json

class MockCommentDataSourceImpl : CommentDataSource {
    override suspend fun getComments(): ResponseResult<List<Comment>> {
        return safeCall {
            Json.decodeFromString<List<Comment>>(Urls.COMMENT_JSON)
        }
    }
}