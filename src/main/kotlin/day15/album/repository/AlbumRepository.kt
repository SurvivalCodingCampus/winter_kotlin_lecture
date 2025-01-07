package org.hyunjung.day15.album.repository

import org.hyunjung.day15.album.model.Album

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}