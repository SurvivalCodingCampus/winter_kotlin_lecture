package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.data_source.PhotoDatasource
import org.example.day15.repository_exam.model.Photo

class PhotoRepositoryImpl(private val datasource: PhotoDatasource) : PhotoRepository {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return datasource.getAllPhotos().filter { it.albumId == albumId }
    }
}