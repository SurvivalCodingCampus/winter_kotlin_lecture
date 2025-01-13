package com.survivalcoding.com.survivalcoding.day18.data_source

import com.survivalcoding.day18.dto.PhotoDto


interface PhotoDataSource {
    suspend fun getPhotos(query: String): List<PhotoDto>
}
