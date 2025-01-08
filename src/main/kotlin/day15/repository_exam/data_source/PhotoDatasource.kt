package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.Photo

interface PhotoDatasource {
    suspend fun getPhoto(albumId: Int): Photo?
    suspend fun savePhoto(photo: Photo)
    suspend fun getAllPhotos(): List<Photo>
}