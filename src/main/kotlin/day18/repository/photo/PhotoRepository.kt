package org.example.day18.repository.photo

import org.example.day18.model.photo.Photo
import org.example.day18.util.photo.PhotoError
import org.example.day18.util.photo.Result

interface PhotoRepository {
    suspend fun getPhotos(query: String): Result<List<Photo>, PhotoError>
}