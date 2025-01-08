package day15

import day15.models.Comment

interface CommentRepository {
    suspend fun findByPostId(id: Int): List<Comment>
}