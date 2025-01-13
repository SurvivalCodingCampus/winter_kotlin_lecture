package org.hyunjung.day18.repository

import org.hyunjung.day18.model.Photo
import org.hyunjung.day18.util.Result

interface PhotoRepository {
    suspend fun getPhotos(query: String): Result<List<Photo>>
}