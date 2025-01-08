package org.example.day15.data.datasource

import kotlinx.coroutines.flow.Flow
import org.example.day15.data.model.Album

interface AlbumDataSource {
    suspend fun getAlbums(): Flow<List<Album>>
}