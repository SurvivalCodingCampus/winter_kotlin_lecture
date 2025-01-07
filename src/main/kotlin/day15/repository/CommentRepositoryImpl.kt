package day15.repository

import day15.data_source.CommentDataSource
import day15.model.Comment

class CommentRepositoryImpl(private val dataSource: CommentDataSource): CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        return dataSource.getComments().filter { it.postId == postId }
    }
}

