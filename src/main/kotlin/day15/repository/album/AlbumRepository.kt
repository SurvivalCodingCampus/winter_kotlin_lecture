package org.example.day15.repository.album

import org.example.day15.data_source.albums.AlbumDataSource
import org.example.day15.model.Album

interface AlbumRepository {
    val dataSource: AlbumDataSource
    suspend fun getAlbums(limit: Int? = null): List<Album>
}