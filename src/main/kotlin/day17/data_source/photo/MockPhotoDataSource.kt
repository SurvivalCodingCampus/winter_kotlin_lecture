package org.example.day17.data_source.photo

import Photo

interface MockPhotoDataSource {
    suspend fun fetchPhotoData(): List<Photo>
}

