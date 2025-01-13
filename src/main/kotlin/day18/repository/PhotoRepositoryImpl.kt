package day18.repository

import day18.datasource.PhotoDataSource
import day18.mapper.mapper
import day18.model.Photo
import day18.utils.PhotoError
import day18.utils.ResponseResult
import day18.utils.safeCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(query: String): ResponseResult<List<Photo>> = withContext(Dispatchers.IO) {

        // 빈스트링 일경우 에러를 던짐
        if (query.isBlank()) {
            return@withContext ResponseResult.Failure(PhotoError.EmptyQuery)
        }

        safeCall {
            val result = dataSource.getPhotos(query).map { it.mapper() }
            println("결과값 뽑기 $result")
            result
        }
    }
}