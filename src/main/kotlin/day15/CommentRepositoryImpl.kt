package day15

import day15.data.CommentDataSource
import day15.models.Comment

class CommentRepositoryImpl(private val source: CommentDataSource) : CommentRepository {
    override suspend fun findByPostId(id: Int): List<Comment> = source.getComments().filter { it.postId == id }
}