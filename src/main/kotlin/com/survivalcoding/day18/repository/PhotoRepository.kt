package com.survivalcoding.com.survivalcoding.day18.repository

import com.survivalcoding.com.survivalcoding.day18.model.Photo
import com.survivalcoding.com.survivalcoding.day18.util.Result


interface PhotoRepository {
    suspend fun getPhotos(query: String): Result<List<Photo>>
}