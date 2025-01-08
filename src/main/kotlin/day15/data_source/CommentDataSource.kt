package org.example.day15.data_source

import kotlinx.serialization.json.Json
import org.example.day15.JsonData.COMMENT_JSON
import org.example.day15.model.Comment

interface CommentDataSource {
    suspend fun getComments(postId: Int): List<Comment>
}

class CommentDataSourceImpl : CommentDataSource {
    override suspend fun getComments(postId: Int): List<Comment> {
        return Json.decodeFromString(COMMENT_JSON)
    }
}


