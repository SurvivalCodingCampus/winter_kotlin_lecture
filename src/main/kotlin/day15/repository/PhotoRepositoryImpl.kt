package day15.repository

import day15.data_source.PhotoDataSource
import day15.model.Photo

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        require(albumId > 0) { "Album ID must be positive" }

        return try {
            dataSource.getPhotos().filter { it.albumId == albumId }
        } catch (e: Exception) {
            throw e  // 또는 적절한 에러 처리 로직 추가
        }
    }
}

