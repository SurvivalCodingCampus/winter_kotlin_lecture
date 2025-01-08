package org.example.day15.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day15.data.datasource.PhotoDataSource
import org.example.day15.data.model.Photo

class PhotoRepositoryImpl(
    private val photoDataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): Flow<List<Photo>> =
        photoDataSource.getPhotos(albumId)
}