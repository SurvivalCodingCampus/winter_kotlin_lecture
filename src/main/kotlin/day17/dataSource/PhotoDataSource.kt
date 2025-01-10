package day17.dataSource

import day17.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhotoData(): List<PhotoDto>
}