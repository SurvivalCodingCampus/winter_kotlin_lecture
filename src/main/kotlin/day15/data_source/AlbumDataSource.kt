package day15.data_source

import day15.model.Album

interface AlbumDataSource {
    fun getAlbums(limit: Int? = null): List<Album>
}