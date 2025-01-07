package day15.repository.comment

import day15.model.Comment

interface CommentsRepository {

    suspend fun getComments(postId: Int): List<Comment>
}