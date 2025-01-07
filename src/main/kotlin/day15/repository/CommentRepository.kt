package org.example.day15.repository

import org.example.day15.data_source.CommentDataSource
import org.example.day15.model.Comment


interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}

class CommentRepositoryImpl(private val dataSource: CommentDataSource) : CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        return dataSource.getComments(postId).filter { it.postId == postId }
    }
}