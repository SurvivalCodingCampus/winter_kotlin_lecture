package day15.data

import day14.Data
import day15.models.Album
import kotlinx.serialization.json.Json

class MockAlbumDataSource : AlbumDataSource {
    override suspend fun getAlbums(): List<Album> = Json.decodeFromString(Data.ALBUMS_STRING)
}