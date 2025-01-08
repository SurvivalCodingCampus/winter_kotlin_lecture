package org.example.day15.repository.photo

import org.example.day15.data_source.photo.PhotoDataSource
import org.example.day15.model.Photo

interface PhotoRepository {
    val dataSource: PhotoDataSource

    suspend fun getPhotos(albumId: Int): List<Photo>
}