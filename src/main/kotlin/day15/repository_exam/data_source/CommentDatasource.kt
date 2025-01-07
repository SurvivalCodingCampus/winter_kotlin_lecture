package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.Comment

interface CommentDatasource {
    fun getComment(id: Int): Comment?
    fun saveComment(comment: Comment)
    fun getAllComment(): List<Comment>
}