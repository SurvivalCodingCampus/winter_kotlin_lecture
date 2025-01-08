package day15.repository

import day15.model.Comment

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}

