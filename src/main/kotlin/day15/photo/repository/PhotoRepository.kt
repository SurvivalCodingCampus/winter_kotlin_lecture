package org.hyunjung.day15.photo.repository

import org.hyunjung.day15.photo.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}