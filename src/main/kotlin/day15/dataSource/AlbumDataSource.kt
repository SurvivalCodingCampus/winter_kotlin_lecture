package day15.dataSource

import day15.model.Album

interface AlbumDataSource {
    suspend fun albumData(): List<Album>
}