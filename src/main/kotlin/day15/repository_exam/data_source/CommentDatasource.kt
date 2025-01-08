package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.Comment

interface CommentDatasource {
    suspend fun getComment(id: Int): Comment?
    suspend fun saveComment(comment: Comment)
    suspend fun getAllComment(): List<Comment>
}