package day15.data

import day15.models.Comment

interface CommentDataSource {
    suspend fun getComments(): List<Comment>
}
