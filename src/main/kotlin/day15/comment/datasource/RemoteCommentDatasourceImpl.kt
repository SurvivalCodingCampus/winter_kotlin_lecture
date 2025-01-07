package org.hyunjung.day15.comment.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.hyunjung.day15.comment.model.Comment
import org.hyunjung.day15.util.Constants
import org.hyunjung.day15.util.JsonParser
import org.hyunjung.day15.util.NetworkUtils

class RemoteCommentDatasourceImpl : CommentDataSource {

    override suspend fun getComments(postId: Int): List<Comment> {
        return withContext(Dispatchers.IO) {
            val url = "${Constants.BASE_URL}/comments?postId=$postId"
            NetworkUtils.executeRequest(url) { response ->
                JsonParser.parseJson(response)
            }
        }
    }
}
