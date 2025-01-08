package org.example.day15.data.datasource

import kotlinx.coroutines.flow.Flow
import org.example.day15.data.model.Photo

interface PhotoDataSource {
    suspend fun getPhotos(albumId: Int): Flow<List<Photo>>
}