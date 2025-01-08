package org.hyunjung.day15.comment.repository

import org.hyunjung.day15.comment.model.Comment

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}