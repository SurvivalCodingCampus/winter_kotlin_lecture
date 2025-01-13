package org.hyunjung.day17.photo.repository

import org.hyunjung.day17.photo.model.Photo

interface PhotoRepository {
    fun getPhotos(): List<Photo>
}