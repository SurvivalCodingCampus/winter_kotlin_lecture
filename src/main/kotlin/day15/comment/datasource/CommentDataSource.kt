package org.hyunjung.day15.comment.datasource

import org.hyunjung.day15.comment.model.Comment

interface CommentDataSource {
    suspend fun getComments(postId: Int): List<Comment>
}