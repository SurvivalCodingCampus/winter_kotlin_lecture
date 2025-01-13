package day18

import day18.datasource.PhotoDataSource
import day18.model.Photo
import day18.util.Result

class PhotoRepositoryImpl(private val source: PhotoDataSource) : PhotoRepository {

    override suspend fun getPhotos(vararg queries: String): Result<List<Photo>> {
        val queryString = queries.filter { it.isNotBlank() }
            .joinToString("+") { it.trim() }
        if (queryString.isBlank()) {
            return Result.Error(PhotoError.EmptyQuery)
        }

        return when (val result = source.getPhotos(queryString)) {
            is Result.Success -> Result.Success(result.data.map { it.toPhoto() })
            is Result.Error -> result
        }

    }
}