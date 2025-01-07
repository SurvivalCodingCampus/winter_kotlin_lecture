package day15

import day15.models.Album

interface AlbumRepository {
    suspend fun take(limit: Int? = null): List<Album>
}