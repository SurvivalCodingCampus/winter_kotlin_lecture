package org.example.day17.repository.photo

import org.example.day17.data_source.photo.PhotoDataSource
import org.example.day17.mapper.photo.toPhoto
import org.example.day17.model.photo.Photo

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getAllPhotos(): List<Photo> {
        return dataSource.getAllPhotos().map { it.toPhoto() }
    }
}