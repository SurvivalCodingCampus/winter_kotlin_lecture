package day15

import day15.models.Photo

interface PhotoRepository {
    suspend fun findByAlbumId(id: Int): List<Photo>
}