package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.Comment

interface CommentDataSource {
    fun getComment(id: Int): Comment?
    fun saveComment(comment: Comment)
    fun getAllComment(): List<Comment>
    fun getComments(postId: Int) : List<Comment>
}