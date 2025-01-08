package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.data_source.CommentDatasource
import org.example.day15.repository_exam.model.Comment

class CommentRepositoryImpl(private val dataSource: CommentDatasource) : CommentRepository {

    override suspend fun getComments(postId: Int): List<Comment> {
        return dataSource.getAllComment().filter { it.postId == postId }
    }
}