package org.example.day18.repository.photo

import io.ktor.client.plugins.*
import kotlinx.io.IOException
import org.example.day18.data_source.photo.PhotoDataSource
import org.example.day18.mapper.photo.toPhoto
import org.example.day18.model.photo.Photo
import org.example.day18.util.photo.PhotoError
import org.example.day18.util.photo.Result

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(query: String): Result<List<Photo>, PhotoError> {
        try {
            if (query == "") throw IllegalArgumentException()

            val fixedQuery = query.replace(" ", "+")
            val photos = dataSource.getPhotos(fixedQuery).map { it.toPhoto() }

            return Result.Success(photos)
        } catch (e: IOException) {
            return Result.Error(PhotoError.NetWorkError)
        } catch (e: IllegalArgumentException) {
            return Result.Error(PhotoError.EmptyQuery)
        } catch (e: ClientRequestException) {
            return Result.Error(PhotoError.ServerError("서버 에러"))
        }
    }
}