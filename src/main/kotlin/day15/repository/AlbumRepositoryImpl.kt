package day15.repository

import day15.dataSource.AlbumDataSource
import day15.model.Album

class AlbumRepositoryImpl(private val dataSource: AlbumDataSource): AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        val albums = dataSource.albumData()
        return if (limit == null) {
            albums
        } else {
            albums.take(limit)
        }
    }
}