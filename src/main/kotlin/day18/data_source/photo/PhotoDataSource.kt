package org.example.day18.data_source.photo

import org.example.day18.dto.photo.PhotoDto

interface PhotoDataSource {
    suspend fun getPhotos(query: String): List<PhotoDto>
}