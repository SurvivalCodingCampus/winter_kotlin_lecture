package org.example.day18.repository

import org.example.day18.model.Photo
import org.example.day18.util.Result

interface PhotoRepository {
    suspend fun getPhotos(query: String): Result<List<Photo>>
}
