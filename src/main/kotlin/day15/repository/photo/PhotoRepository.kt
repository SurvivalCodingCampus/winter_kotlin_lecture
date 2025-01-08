package day15.repository.photo

import day15.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int) : List<Photo>
}