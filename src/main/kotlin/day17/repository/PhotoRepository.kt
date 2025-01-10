package day17.repository

import day17.model.Photo

interface PhotoRepository {
    suspend fun getPhotoList(): List<Photo>
}