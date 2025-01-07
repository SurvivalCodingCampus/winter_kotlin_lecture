package org.example.day15.data.mock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.util.jsonConfig
import org.example.day15.data.datasource.AlbumDataSource
import org.example.day15.data.model.Album
import org.example.day15.data.resource.albumsData

class MockAlbumDataSourceImpl : AlbumDataSource {
    private val albums = jsonConfig.decodeFromString<List<Album>>(albumsData)
    override suspend fun getAlbums(): Flow<List<Album>> = flow {
        emit(albums)
    }
}