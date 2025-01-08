package org.example.day15.repository.comment

import org.example.day15.data_source.comment.CommentDataSource
import org.example.day15.model.Comment

interface CommentRepository {
    val dataSource: CommentDataSource

    suspend fun getComments(postId: Int): List<Comment>
}