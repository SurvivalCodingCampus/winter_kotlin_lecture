package day15.repository

import day15.model.Comment

class MockCommentDataSourceImpl {
    override suspend fun getComments(): List<Comment> {
        TODO("Not yet implemented")
    }
}