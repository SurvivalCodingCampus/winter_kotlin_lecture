package org.hyunjung.day15.comment.repository

import org.hyunjung.day15.comment.datasource.CommentDataSource
import org.hyunjung.day15.comment.model.Comment

class CommentRepositoryImpl(
    private val remoteDataSource: CommentDataSource,
    private val mockDataSource: CommentDataSource? = null
) : CommentRepository {

    override suspend fun getComments(postId: Int): List<Comment> {
        return try {
            remoteDataSource.getComments(postId)
        } catch (e: Exception) {
            mockDataSource?.getComments(postId) ?: emptyList()
        }
    }
}