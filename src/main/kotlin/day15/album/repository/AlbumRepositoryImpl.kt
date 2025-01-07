package org.hyunjung.day15.album.repository

import org.hyunjung.day15.album.datasource.AlbumDataSource
import org.hyunjung.day15.album.model.Album

class AlbumRepositoryImpl(
    private val dataSource: AlbumDataSource
) : AlbumRepository {

    override suspend fun getAlbums(limit: Int?): List<Album> {
        val albums = dataSource.getAlbums()
        return if (limit != null) albums.take(limit) else albums
    }
}