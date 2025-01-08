package org.example.day16.use_case

import org.example.core.UseCase
import org.example.core.VoidParams
import org.example.day15.repository.comment.CommentRepository
import org.example.day15.repository.post.PostRepository
import org.example.day16.use_case.model.PostTitleWithCommentCount

class GetAndPrintPostTitlesWithCommentCountUseCase(
    val postRepository: PostRepository,
    val commentRepository: CommentRepository,
) : UseCase<VoidParams, List<PostTitleWithCommentCount>> {
    override suspend fun call(params: VoidParams): List<PostTitleWithCommentCount> {
        val stringBuilder = StringBuilder()
        stringBuilder.append("==============\n")
        val posts = postRepository.getPostsInfoList()
        val result = posts.map { post ->
            val matchedComment = commentRepository.getComments(post.id)
            stringBuilder.append("제목: ${post.title}\n코맨트 갯수: ${matchedComment.size}\n==============\n")
            PostTitleWithCommentCount(post.title, matchedComment.size)
        }
        println(stringBuilder.toString())
        return result
    }
}