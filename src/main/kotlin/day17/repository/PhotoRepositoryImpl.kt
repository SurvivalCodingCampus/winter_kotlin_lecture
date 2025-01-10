package day17.repository

import day17.dataSource.PhotoDataSource
import day17.mapper.photoMapper
import day17.model.Photo

class PhotoRepositoryImpl(private val photoDataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun responsePhotoData(): List<Photo> {
        return try {
            val photoDtoList = photoDataSource.getPhotoData()
            photoDtoList.map { photoMapper(it) }
        } catch (e: Exception) {
            throw IllegalStateException("사진 데이터를 가져오는 중 오류가 발생했습니다", e)
        }
    }
}