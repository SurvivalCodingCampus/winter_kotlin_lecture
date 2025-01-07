package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.model.Photo

interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}