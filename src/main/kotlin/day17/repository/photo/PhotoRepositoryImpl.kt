package org.example.day17.repository.photo

import org.example.day17.data_source.photo.MockPhotoDataSourceImpl
import day17.PhotoDataSource
import Photo


class PhotoRepositoryImpl(
    private val getPhoto: PhotoDataSource = MockPhotoDataSourceImpl()
) : PhotoRepository {
    override suspend fun getPhotos(): List<Photo> {
        return getPhoto.getPhotos()
    }
}