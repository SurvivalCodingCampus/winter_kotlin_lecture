package day18.repository

import day18.model.Photo
import day18.utils.Result

interface PhotoRepository {
    suspend fun getPhotoList(keyword: String): Result<List<Photo>>
}