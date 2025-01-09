package org.example.day17.datasource

import org.example.day17.model.Photo

interface PhotoDataSource {
    suspend fun getPhotos(): List<Photo>
}