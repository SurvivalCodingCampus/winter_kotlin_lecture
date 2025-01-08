package day15.repository

import day15.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int) : List<Photo>
}

