package day17.repository

import day17.data_source.PhotoDataSource
import day17.mapper.toPhoto
import day17.model.Photo

class PhotoRepositoryImpl(private val photoDataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotoList(): List<Photo> {
        return photoDataSource.getPhotoList()
            .map { it.toPhoto() }
    }
}