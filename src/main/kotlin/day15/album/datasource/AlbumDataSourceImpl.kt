package org.hyunjung.day15.album.datasource

import org.hyunjung.day15.album.model.Album
import org.hyunjung.day15.util.Constants
import org.hyunjung.day15.util.JsonParser
import org.hyunjung.day15.util.NetworkUtils

class AlbumDataSourceImpl : AlbumDataSource {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        val url = "${Constants.BASE_URL}/albums"
        return NetworkUtils.executeRequest(url) { response ->
            JsonParser.parseJson(response)
        }
    }
}