package day15.data_source.album

import utils.network.ResponseResult
import utils.network.safeCall
import day15.model.Album
import day15.util.Urls
import kotlinx.serialization.json.Json

class MockAlbumDataSourceImpl : AlbumDataSource {
    override suspend fun getAlbums(): ResponseResult<List<Album>> {
        return safeCall {
            Json.decodeFromString<List<Album>>(Urls.ALBUM_DATA)
        }
    }
}