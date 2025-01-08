package org.example.day15.data_source.albums

import org.example.day15.data_source.DataSource
import org.example.day15.model.Album

interface AlbumDataSource : DataSource {
    suspend fun getAlbums(): List<Album>
}