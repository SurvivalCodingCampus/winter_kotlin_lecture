package org.hyunjung.day15.comment.datasource

import org.hyunjung.day15.comment.model.Comment

class MockCommentDataSourceImpl : CommentDataSource {
    override suspend fun getComments(postId: Int): List<Comment> {
        return listOf(
            Comment(postId, 1, "Mock User 1", "mock1@example.com", "Mock Data 1"),
            Comment(postId, 2, "Mock User 2", "mock2@example.com", "Mock Data 2"),
            Comment(postId, 3, "Mock User 3", "mock3@example.com", "Mock Data 3")
        )
    }
}