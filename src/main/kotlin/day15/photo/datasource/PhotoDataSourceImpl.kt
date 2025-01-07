package org.hyunjung.day15.photo.datasource

import org.hyunjung.day15.photo.model.Photo
import org.hyunjung.day15.util.Constants
import org.hyunjung.day15.util.JsonParser
import org.hyunjung.day15.util.NetworkUtils

class PhotoDataSourceImpl : PhotoDataSource {

    override suspend fun getPhotos(albumId: Int): List<Photo> {
        val url = "${Constants.BASE_URL}/photos?albumId=$albumId"
        return NetworkUtils.executeRequest(url) { response ->
            JsonParser.parseJson(response)
        }
    }
}