package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.data_source.CommentDataSource
import org.example.day15.repository_exam.data_source.MockCommentDatasource
import org.example.day15.repository_exam.model.Comment

class CommentRepositoryImpl(private val dataSource: MockCommentDatasource) : CommentRepository {

    override suspend fun getComments(postId: Int): List<Comment> {
        return dataSource.getComments(postId)
    }
}