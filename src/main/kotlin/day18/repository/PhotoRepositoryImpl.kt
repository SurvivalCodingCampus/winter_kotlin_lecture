package org.hyunjung.day18.repository

import org.hyunjung.day18.datasource.PhotoDataSource
import org.hyunjung.day18.mapper.PhotoMapper
import org.hyunjung.day18.model.Photo
import org.hyunjung.day18.util.Result

class PhotoRepositoryImpl(
    private val datastore: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(query: String): Result<List<Photo>> {
        return try {
            val response = datastore.getPhotos(query)
            val photos = response.hits.mapNotNull { PhotoMapper.map(it) }

            if (photos.isEmpty()) {
                Result.Error("No photos found for query: $query")
            } else {
                Result.Success(photos)
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unkown Error")
        }
    }
}