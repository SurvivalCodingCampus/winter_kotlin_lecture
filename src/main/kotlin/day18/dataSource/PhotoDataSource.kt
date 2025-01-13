package day18.dataSource

import PhotoDto

interface PhotoDataSource {
    suspend fun getPhoto(query: String): List<PhotoDto>
}