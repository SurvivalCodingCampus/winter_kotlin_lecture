package day15.data_source

import day15.model.Comment

interface CommentDataSource {
    fun getComments(): List<Comment>
}