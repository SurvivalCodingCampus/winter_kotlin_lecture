package org.hyunjung.day15.comment.datasource

import org.hyunjung.day15.comment.model.Comment
import org.hyunjung.day15.util.Constants
import org.hyunjung.day15.util.JsonParser
import org.hyunjung.day15.util.NetworkUtils

class RemoteCommentDatasourceImpl : CommentDataSource {

    override suspend fun getComments(postId: Int): List<Comment> {
        val url = "${Constants.BASE_URL}/comments?postId=$postId"
        return NetworkUtils.executeRequest(url) { response ->
            JsonParser.parseJson(response)
        }
    }
}
