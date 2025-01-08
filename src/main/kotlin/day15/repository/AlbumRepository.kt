package day15.repository

import day15.model.Album

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}
