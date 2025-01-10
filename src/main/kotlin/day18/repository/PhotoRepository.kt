package day18.repository

import day18.model.Photo

interface PhotoRepository {
    suspend fun getPhotoList(keyword: String): List<Photo>
}