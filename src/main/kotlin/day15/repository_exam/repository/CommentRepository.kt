package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.model.Comment

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}