package org.example.day15.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day15.data.model.Comment

interface CommentRepository {
    suspend fun getComments(postId: Int): Flow<List<Comment>>
}