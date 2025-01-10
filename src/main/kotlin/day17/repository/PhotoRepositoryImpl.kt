package day17.repository

import utils.network.ResponseResult
import day17.datasource.PhotoDataSource
import day17.mapper.mapper
import day17.model.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotoRepositoryImpl(
    private val photoDataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getUsePhotoData(): List<Photo> = withContext(Dispatchers.IO) {
        when (val result = photoDataSource.getPhoto()) {
            is ResponseResult.Success -> {
                result.data.map { it.mapper() }
            }

            is ResponseResult.Failure -> {
                println("통신 실패" + result.exception.message)
                emptyList()
            }
        }
    }
}

