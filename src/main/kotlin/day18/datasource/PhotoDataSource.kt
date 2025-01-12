package day18.datasource

import day18.dto.PhotoDto
import day18.util.Result

interface PhotoDataSource {
    suspend fun getPhotos(query: String): Result<List<PhotoDto>>
}