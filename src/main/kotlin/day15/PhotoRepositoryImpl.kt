package day15

import day15.data.PhotoDataSource
import day15.models.Photo

class PhotoRepositoryImpl(private val source: PhotoDataSource) : PhotoRepository {
    override suspend fun findByAlbumId(id: Int): List<Photo> = source.getPhotos().filter { it.albumId == id }
}