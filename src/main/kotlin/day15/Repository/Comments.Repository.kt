package org.example.day15.Repository

import CommentDataSource
import CommentRepositoryImpl
import org.example.day15.Model.Comment
import org.example.day15.Utils.parseJson
import org.example.day15.Utils.readJson


open class CommentDataSourceImpl(private val jsonDataSource: String) : CommentDataSource, CommentRepositoryImpl {
    private var _comments: List<Comment> = parseJson(jsonDataSource)

    override val comments: List<Comment>
        get() = _comments

    override suspend fun getComments(postId: Int): List<Comment> {
        try {
            return comments.filter { comment ->
                comment.postId == postId
            }
        } catch (e: Exception) {
            throw Exception("unexpected error")
        }
    }
}


const val commentDataSource = "./src/main/kotlin/day15/RawData/comments.json"

class CommentRepository : CommentDataSourceImpl(readJson(commentDataSource)) {}