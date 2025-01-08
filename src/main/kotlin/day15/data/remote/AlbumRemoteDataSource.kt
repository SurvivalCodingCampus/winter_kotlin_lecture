package org.example.day15.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.util.fetchData
import org.example.day15.data.datasource.AlbumDataSource
import org.example.day15.data.model.Album
import org.example.day15.data.resource.BASE_URL

class AlbumRemoteDataSource : AlbumDataSource {
    override suspend fun getAlbums(): Flow<List<Album>> = flow {
        emit(fetchData<List<Album>>("$BASE_URL/albums"))
    }
}