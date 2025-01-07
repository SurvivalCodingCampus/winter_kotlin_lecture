package org.example.day15.repository

import org.example.day15.data_source.PhotoDataSource
import org.example.day15.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return dataSource.getPhotos(albumId).filter { it.albumId == albumId }
    }
}