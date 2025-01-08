package org.example.day15.repository.album

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import org.example.day15.data_source.albums.AlbumDataSource
import org.example.day15.model.Album

class AlbumRepositoryImpl(override val dataSource: AlbumDataSource) : AlbumRepository {

    override suspend fun getAlbums(limit: Int?): List<Album> = withContext(Dispatchers.IO) {
        try {
            dataSource.getAlbums().take(limit ?: Int.MAX_VALUE)
        } catch (e: Exception) {
            when (e) {
                is SerializationException -> throw e
                else -> emptyList()
            }
        }

    }
}