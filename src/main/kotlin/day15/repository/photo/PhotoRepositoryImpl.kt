package org.example.day15.repository.photo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import org.example.day15.data_source.photo.PhotoDataSource
import org.example.day15.model.Photo

class PhotoRepositoryImpl(override val dataSource: PhotoDataSource) : PhotoRepository {

    override suspend fun getPhotos(albumId: Int): List<Photo> = withContext(Dispatchers.IO) {
        try {
            dataSource.getPhotos().filter { it.albumId == albumId }
        } catch (e: Exception) {
            when (e) {
                is SerializationException -> throw e
                else -> emptyList()
            }
        }
    }
}