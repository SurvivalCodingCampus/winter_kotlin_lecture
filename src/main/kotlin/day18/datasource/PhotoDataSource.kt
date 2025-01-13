package day18.datasource

import day18.dto.PhotoDto


interface PhotoDataSource {
    suspend fun getPhotos(query: String): List<PhotoDto>
}