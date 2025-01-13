package day18

import day18.model.Photo
import day18.util.Result

interface PhotoRepository {
    suspend fun getPhotos(vararg queries: String): Result<List<Photo>>
}