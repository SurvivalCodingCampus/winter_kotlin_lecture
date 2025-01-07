package org.hyunjung.day15.album.datasource

import org.hyunjung.day15.album.model.Album

interface AlbumDataSource {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}