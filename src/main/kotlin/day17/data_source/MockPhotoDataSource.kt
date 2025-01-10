package day17

import Photo

interface MockPhotoDataSource {
    suspend fun fetchPhotoData(): List<Photo>
}

