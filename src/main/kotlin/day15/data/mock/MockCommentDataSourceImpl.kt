package org.example.day15.data.mock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.util.jsonConfig
import org.example.day15.data.model.Comment
import org.example.day15.data.repository.CommentRepository
import org.example.day15.data.resource.commentsJsonString

class MockCommentDataSourceImpl : CommentRepository {
    private val comments = jsonConfig.decodeFromString<List<Comment>>(commentsJsonString)
    override suspend fun getComments(postId: Int): Flow<List<Comment>> = flow {
        emit(comments.filter { it.postId == postId })
    }
}