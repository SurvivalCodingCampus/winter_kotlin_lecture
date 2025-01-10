package day18.repository

import day18.model.Photo
import day18.utils.ResponseResult

interface PhotoRepository {
    suspend fun getPhotos(query: String): ResponseResult<List<Photo>>
}