package day15.dataSource

import day15.model.Comment

interface CommentDataSource {
    suspend fun commentData(): List<Comment>
}