package org.example.day18.repository

import org.example.day18.datasource.PhotoDataSource
import org.example.day18.mapper.toPhotoList
import org.example.day18.model.Photo
import org.example.day18.util.PhotoError
import org.example.day18.util.Result

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(query: String): Result<List<Photo>> {
        return if (query.isBlank()) {
            Result.Error(PhotoError.EmptyQuery)
        } else {
            try {
                val photoDtos = dataSource.getPhotos(query)
                val photos = photoDtos.toPhotoList()

                Result.Success(photos)
            } catch (e: Exception) {
                Result.Error(PhotoError.NetworkError)
            }
        }
    }
}
