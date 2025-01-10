package day15.repository.comment

import utils.network.ResponseResult
import day15.data_source.comment.CommentDataSource
import day15.model.Comment

class CommentRepositoryImpl(
    private val dataSource: CommentDataSource
) : CommentsRepository {
    override suspend fun getComments(postId: Int): List<Comment> {

        return when (val result = dataSource.getComments()) {
            is ResponseResult.Success -> {
                // postId가 같은 것을 리턴해줌
                result.data.filter { it.postId == postId }
            }

            is ResponseResult.Failure -> {
                return emptyList()
            }
        }
    }
}