package org.hyunjung.day15.photo.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.hyunjung.day15.photo.model.Photo
import org.hyunjung.day15.util.Constants
import org.hyunjung.day15.util.JsonParser
import org.hyunjung.day15.util.NetworkUtils
import java.net.HttpURLConnection

class PhotoDataSourceImpl : PhotoDataSource {

    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return withContext(Dispatchers.IO) {
            val url = "${Constants.BASE_URL}/photos?albumId=$albumId"
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