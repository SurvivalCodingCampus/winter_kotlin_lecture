package org.hyunjung.day15.photo.repository

import org.hyunjung.day15.photo.datasource.PhotoDataSource
import org.hyunjung.day15.photo.model.Photo

class PhotoRepositoryImpl(private val photoDataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhoto(albumId: Int): List<Photo> {
        return photoDataSource.getPhotos(albumId)
    }
}