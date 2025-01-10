package day18.repository

import day18.data_source.PhotoDataSource
import day18.mapper.toPhoto
import day18.model.Photo
import day18.utils.PhotoError
import day18.utils.Result

class PhotoRepositoryImpl(private val photoDataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotoList(keyword: String): Result<List<Photo>> {

        if (keyword.isEmpty()) {
            return Result.Error(PhotoError.EmptyQuery)
        }

        return try {
            val photos = photoDataSource.getPhotoList(keyword)
                .map { it.toPhoto() }

            if (photos.isEmpty()) {
                throw PhotoError.EmptyPhoto
            }

            Result.Success(photos)
        } catch (e: Exception) {
            when (e) {
                is IllegalStateException -> Result.Error(PhotoError.ServerError(e.message ?: "Unknown Server Error"))
                else -> Result.Error(PhotoError.NetworkError)
            }
        }
    }
}