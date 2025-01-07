package org.example.day15.Repository

import CommentDataSource
import CommentRepositoryImpl
import org.example.day15.Model.Comment
import org.example.day15.Utils.parseJson


open class CommentDataSourceImpl(private val jsonFilePath: String) : CommentDataSource, CommentRepositoryImpl {
    override var comments: List<Comment>
        get() = parseJson(jsonFilePath)
        set(value) {}

    override suspend fun getComments(postId: Int): List<Comment> {
        if (comments.isEmpty()) emptyList<String?>()
        return comments.filter { comment ->
            comment.postId == postId
        }
    }
}


const val commentDataSource = "./src/main/kotlin/day15/RawData/comments.json"

class CommentRepository : CommentDataSourceImpl(commentDataSource) {}