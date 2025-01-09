package org.example.day17.repository

import org.example.day17.datasource.PhotoDataSource
import org.example.day17.model.Photo
import org.example.day17.model.Type

class PhotoRepositoryImpl(
    private val photoDataSource: PhotoDataSource
) : PhotoRepository {
    override suspend fun getPhotoById(id: Int): Photo =
        photoDataSource.getPhotos().first { it.id == id }

    override suspend fun getPhotosByType(type: Type): List<Photo> =
        photoDataSource.getPhotos().filter { it.type == type }

    override suspend fun getPhotos(): List<Photo> =
        photoDataSource.getPhotos()
}