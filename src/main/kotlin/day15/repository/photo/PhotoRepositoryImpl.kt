package day15.repository.photo

import day15.common.ResponseResult
import day15.data_source.photo.PhotoDataSource
import day15.model.Photo

class PhotoRepositoryImpl(
    private val photoDataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {

        return when (val result = photoDataSource.getPhotos()) {
            is ResponseResult.Success -> {
                result.data.filter { it.albumId == albumId }
            }

            is ResponseResult.Failure -> {
                println("데이터 조회 실패: ${result.exception.message}")
                throw result.exception
            }
        }
    }

}