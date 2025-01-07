package org.example.day15.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.take
import org.example.day15.data.datasource.AlbumDataSource
import org.example.day15.data.model.Album

class AlbumRepositoryImpl(
    private val albumDataSource: AlbumDataSource
) : AlbumRepository {
    override suspend fun getAlbums(): Flow<List<Album>> =
        albumDataSource.getAlbums()

    override suspend fun getAlbums(limit: Int): Flow<List<Album>> =
        albumDataSource.getAlbums().take(limit)
}