package day18.data_source

import day18.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhotoList(keyword: String): List<PhotoDto>
}