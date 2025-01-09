package day17.repository

import day15.common.ResponseResult
import day17.datasource.MockPhotoDataSourceImpl
import day17.mapper.mapper
import day17.model.Photo
import day17.utils.Const
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class PhotoRepositoryImpl(
    private val photoDataSourceImpl: MockPhotoDataSourceImpl
) : PhotoRepository {
    override suspend fun getUsePhotoData(): List<Photo> = withContext(Dispatchers.IO) {
        when (val result = photoDataSourceImpl.getPhoto()) {
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

fun main() = runBlocking {
    val photoTest = PhotoRepositoryImpl(MockPhotoDataSourceImpl(Const.SECOND_PHOTO_JSON))
    val data = photoTest.getUsePhotoData()
    println(data)
}
