package day15.repository

import day15.data_source.AlbumDataSource
import day15.model.Album

class AlbumRepositoryImpl(private val dataSource: AlbumDataSource): AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        return dataSource.getAlbums(limit)
    }
}
