package org.example.day15.repository.comment

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import org.example.day15.data_source.comment.CommentDataSource
import org.example.day15.model.Comment

class CommentRepositoryImpl(override val dataSource: CommentDataSource) : CommentRepository {

    override suspend fun getComments(postId: Int): List<Comment> = withContext(Dispatchers.IO) {
        try {
            dataSource.getComments().filter { it.postId == postId }
        } catch (e: Exception) {
            when (e) {
                is SerializationException -> throw e
                else -> emptyList()
            }
        }
    }
}