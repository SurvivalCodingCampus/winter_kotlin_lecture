package org.example.day15.repository

import org.example.day15.data_source.AlbumDataSource
import org.example.day15.model.Album

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}

class AlbumRepositoryImpl(private val dataSource: AlbumDataSource) : AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        val albums = dataSource.getAlbums()
        return limit?.let {// non-null 체크
            albums.take(it) // limit이 지정된 경우, 해당 갯수만큼 반환
        } ?: albums
    }
}