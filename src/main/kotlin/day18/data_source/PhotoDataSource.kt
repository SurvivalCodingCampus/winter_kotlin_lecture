package org.example.day18.data_source

import day18.dto.PhotoDto
import org.example.day18.model.PhotoOrder

interface PhotoDataSource {
    suspend fun getPhotos(query: String, order: PhotoOrder = PhotoOrder.LATEST): List<PhotoDto>
}