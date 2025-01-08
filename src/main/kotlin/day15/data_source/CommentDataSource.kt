package day15.data_source

import day15.model.Comment

interface CommentDataSource {
    suspend fun commentData(): List<Comment>
}