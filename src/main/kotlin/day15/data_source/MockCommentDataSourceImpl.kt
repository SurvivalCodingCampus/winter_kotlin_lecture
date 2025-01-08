package day15.data_source

import day15.model.Comment
import day15.util.JsonData
import kotlinx.serialization.json.Json

class MockCommentDataSourceImpl: CommentDataSource {
    override suspend fun commentData(): List<Comment> {// 예외처리
        return Json.decodeFromString<List<Comment>>(JsonData.COMMENT_DATA)
    }
}