package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.Photo

interface PhotoDatasource {
    fun getPhoto(albumId: Int): Photo?
    fun savePhoto(photo: Photo)
    fun getAllPhotos(): List<Photo>
}