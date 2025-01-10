package day18.repository

import day18.data_source.PhotoDataSource
import day18.mapper.toPhoto
import day18.model.Photo

class PhotoRepositoryImpl(private val photoDataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotoList(keyword: String): List<Photo> {
        return photoDataSource.getPhotoList(keyword)
            .map { it.toPhoto() }
    }
}