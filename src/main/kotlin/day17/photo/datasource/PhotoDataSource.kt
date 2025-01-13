package org.hyunjung.day17.photo.datasource

import org.hyunjung.day17.photo.dto.PhotoDto

interface PhotoDataSource {
    fun getPhotos(): List<PhotoDto>
}