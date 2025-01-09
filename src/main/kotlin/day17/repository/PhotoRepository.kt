package org.example.day17.repository

import org.example.day17.model.Photo
import org.example.day17.model.Type

interface PhotoRepository {
    suspend fun getPhotoById(id: Int): Photo
    suspend fun getPhotosByType(type: Type): List<Photo>
    suspend fun getPhotos(): List<Photo>
}