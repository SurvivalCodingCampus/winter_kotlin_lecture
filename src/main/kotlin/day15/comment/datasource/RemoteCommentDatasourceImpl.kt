package org.hyunjung.day15.comment.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.hyunjung.day15.comment.model.Comment
import org.hyunjung.day15.util.Constants
import org.hyunjung.day15.util.JsonParser
import org.hyunjung.day15.util.NetworkUtils
import java.net.HttpURLConnection

class RemoteCommentDatasourceImpl : CommentDataSource {

    override suspend fun getComments(postId: Int): List<Comment> {
        return withContext(Dispatchers.IO) {
            val url = "${Constants.BASE_URL}/comments?postId=$postId"
            val connection = NetworkUtils.createHttpConnection(url)

            try {
               connection.connect()
                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    val response = NetworkUtils.readStream(connection.inputStream)
                    JsonParser.parseJson(response)
                } else {
                    throw Exception(NetworkUtils.handleHttpError(connection.responseCode))
                }
            } finally {
                connection.disconnect()
            }
        }
    }
}
