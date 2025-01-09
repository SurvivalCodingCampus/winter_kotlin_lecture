package day15.repository

import day15.dataSource.PhotoDataSource
import day15.model.Photo

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource): PhotoRepository {
    override suspend fun getPhotos(albumId: Int) : List<Photo> {
        return dataSource.photoData().filter { it.albumId == albumId }
    }
}