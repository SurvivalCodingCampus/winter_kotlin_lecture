package org.example.day18.repository

import org.example.day14.data.result.Result
import org.example.day18.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(query: String): Result<List<Photo>>
}