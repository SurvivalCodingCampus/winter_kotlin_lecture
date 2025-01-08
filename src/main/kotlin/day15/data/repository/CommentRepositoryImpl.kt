package org.example.day15.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day15.data.datasource.CommentDataSource
import org.example.day15.data.model.Comment

class CommentRepositoryImpl(
    private val commentDataSource: CommentDataSource
) : CommentRepository {
    override suspend fun getComments(postId: Int): Flow<List<Comment>> =
        commentDataSource.getComments(postId)
}