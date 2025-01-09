package org.example.day17.repository.photo

import org.example.day17.model.photo.Photo

interface PhotoRepository {
    suspend fun getAllPhotos(): List<Photo>
}