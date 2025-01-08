package day15.data_source

import day15.model.Photo

interface PhotoDataSource {
    suspend fun getPhotos(): List<Photo>
}