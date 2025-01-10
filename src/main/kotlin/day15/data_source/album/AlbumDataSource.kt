package day15.data_source.album

import utils.network.ResponseResult
import day15.model.Album

interface AlbumDataSource {
    suspend fun getAlbums(): ResponseResult<List<Album>>
}