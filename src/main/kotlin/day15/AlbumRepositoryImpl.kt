package day15

import day15.data.AlbumDataSource
import day15.models.Album

class AlbumRepositoryImpl(private val source: AlbumDataSource) : AlbumRepository {
    override suspend fun take(limit: Int?): List<Album> = source.getAlbums().let {
        limit?.let { n -> it.take(n) } ?: it
    }
}