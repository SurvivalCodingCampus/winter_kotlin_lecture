package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.Album

interface AlbumDatasource {
    fun getAlbum(id: Int): Album
    fun saveAlbum(album: Album)
    fun getAllAlbums(): List<Album>
}