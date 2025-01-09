package day15.dataSource

import day15.model.Album
import day15.util.JsonData
import kotlinx.serialization.json.Json

class AlbumDataSourceImpl: AlbumDataSource {
    override suspend fun albumData(): List<Album> {
        return Json.decodeFromString<List<Album>>(JsonData.ALBUM_DATA)
    }
}