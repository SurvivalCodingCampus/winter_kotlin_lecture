package day17

import Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
}