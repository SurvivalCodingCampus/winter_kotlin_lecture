package org.example.day15.data_source

import kotlinx.serialization.json.Json
import org.example.day15.JsonData.ALBUM_JSON
import org.example.day15.model.Album

interface AlbumDataSource {
    suspend fun getAlbums(): List<Album>
}

class AlbumDataSourceImpl : AlbumDataSource {
    override suspend fun getAlbums(): List<Album> {
        return Json.decodeFromString(ALBUM_JSON)
    }
}