package day15.data

import day15.models.Photo

interface PhotoDataSource {
    suspend fun getPhotos(): List<Photo>
}