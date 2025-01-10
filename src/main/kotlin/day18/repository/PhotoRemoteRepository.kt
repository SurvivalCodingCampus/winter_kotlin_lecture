package org.example.day18.repository

import kotlinx.io.IOException
import org.example.day14.data.result.Result
import org.example.day18.datasource.PhotoDataSource
import org.example.day18.model.Photo
import org.example.day18.util.PhotoError

class PhotoRemoteRepository(
    private val photoDataSource: PhotoDataSource,
) : PhotoRepository {
    override suspend fun getPhotos(query: String): Result<List<Photo>> {
        if (query.isBlank()) {
            return Result.Error(PhotoError.NetworkError)
        }
        return try {
            val photos = photoDataSource.getPhotos(query)
            Result.Success(photos)
        } catch (e: IOException) {
            Result.Error(PhotoError.NetworkError)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}