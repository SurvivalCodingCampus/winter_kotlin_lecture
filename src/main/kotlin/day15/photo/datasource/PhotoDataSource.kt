package org.hyunjung.day15.photo.datasource

import org.hyunjung.day15.photo.model.Photo

interface PhotoDataSource {
    suspend fun getPhotos(albumId: Int): List<Photo>
}