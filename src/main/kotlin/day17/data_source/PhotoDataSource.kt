package day17.data_source

import day17.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhotoList(): List<PhotoDto>
}