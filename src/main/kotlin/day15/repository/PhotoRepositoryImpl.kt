package day15.repository

import day15.data_source.PhotoDataSource
import day15.model.Photo

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return dataSource.getPhotos().filter { it.albumId == albumId }
    }
}

