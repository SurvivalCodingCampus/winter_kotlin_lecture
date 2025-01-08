package day15.repository

import day15.data_source.AlbumDataSource
import day15.data_source.MockAlbumDatasourceImpl
import day15.model.Album
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class AlbumRepositoryImpl(private val dataSource: AlbumDataSource): AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        return if (limit == null) dataSource.getAlbums() else dataSource.getAlbums().take(limit)
    }
}
