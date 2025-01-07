package day15.data

import day14.Data
import day15.models.Comment
import kotlinx.serialization.json.Json

class MockCommentDataSource : CommentDataSource {
    override suspend fun getComments(): List<Comment> = Json.decodeFromString(Data.COMMENTS_STRING)
}