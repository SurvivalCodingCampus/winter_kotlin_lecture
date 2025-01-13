package day18.repository

import ResultPhoto
import day18.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(query: String): ResultPhoto<List<Photo>>

}