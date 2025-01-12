package day17

import Photo

interface PhotoRepositoryImpl {
    suspend fun getPhotos(albumId: Int): List<Photo>
}

interface PhotoDataSource {
    suspend fun getPhotos(): List<Photo>
}
