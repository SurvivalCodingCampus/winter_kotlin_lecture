package org.example.day15.data.datasource

import kotlinx.coroutines.flow.Flow
import org.example.day15.data.model.Comment

interface CommentDataSource {
    suspend fun getComments(postId: Int): Flow<List<Comment>>
}