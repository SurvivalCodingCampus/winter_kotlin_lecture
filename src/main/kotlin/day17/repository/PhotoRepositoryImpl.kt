package org.example.day17.repository

import day17.MockPhotoDataSourceImpl
import day17.PhotoDataSource
import Photo
import day17.PhotoRepository


class PhotoRepositoryImpl(
    private val getPhoto: PhotoDataSource = MockPhotoDataSourceImpl()
) : PhotoRepository {
    override suspend fun getPhotos(): List<Photo> {
        return getPhoto.getPhotos()
    }
}