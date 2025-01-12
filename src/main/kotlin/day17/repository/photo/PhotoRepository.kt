package org.example.day17.repository.photo

import Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
}