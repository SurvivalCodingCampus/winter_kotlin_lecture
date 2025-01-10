package org.example.day18.datasource

import org.example.day18.model.Photo

interface PhotoDataSource {
    suspend fun getPhotos(query: String): List<Photo>
}