package day15.dataSource

import day15.model.Comment
import day15.util.JsonData
import kotlinx.serialization.json.Json

class MockCommentDataSourceImpl: CommentDataSource {
    override suspend fun commentData(): List<Comment> { //todo 예외처리
        return Json.decodeFromString<List<Comment>>(JsonData.COMMENT_DATA)
    }
}