package org.example.day18.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.example.day18.data_source.PhotoDataSource
import org.example.day18.error.PhotoError
import org.example.day18.mapper.toModel
import org.example.day18.model.Photo
import org.example.day18.model.PhotoOrder
import org.example.day18.util.Result

class PhotoRepositoryImpl(override val dataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(
        query: String,
        order: PhotoOrder
    ): Result<List<Photo>> = withContext(Dispatchers.IO) {
        try {
            if (query.isBlank()) {
                Result.Error(PhotoError.EmptyError)
            } else {
                val response = dataSource.getPhotos(query, order)
                Result.Success(response.map { it.toModel() })
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}