package day15.data

import day15.models.Album

interface AlbumDataSource {
    suspend fun getAlbums(): List<Album>
}