package org.example.day15.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day15.data.model.Album

interface AlbumRepository {
    suspend fun getAlbums(): Flow<List<Album>>
    suspend fun getAlbums(limit: Int): Flow<List<Album>>
}