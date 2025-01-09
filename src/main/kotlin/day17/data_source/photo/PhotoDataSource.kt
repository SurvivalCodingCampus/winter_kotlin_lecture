package org.example.day17.data_source.photo

import org.example.day17.dto.photo.PhotoDto

interface PhotoDataSource {
    suspend fun getAllPhotos(): List<PhotoDto>
}