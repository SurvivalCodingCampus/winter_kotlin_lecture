package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.Album

interface AlbumDatasource {
    suspend fun getAlbum(id: Int): Album
    suspend fun saveAlbum(album: Album)
    suspend fun getAllAlbums(): List<Album>
}