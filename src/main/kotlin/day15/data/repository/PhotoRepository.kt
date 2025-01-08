package org.example.day15.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day15.data.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): Flow<List<Photo>>
}