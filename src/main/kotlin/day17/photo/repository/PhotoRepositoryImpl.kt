package org.hyunjung.day17.photo.repository

import org.hyunjung.day17.photo.datasource.PhotoDataSource
import org.hyunjung.day17.photo.mapper.PhotoMapper
import org.hyunjung.day17.photo.model.Photo

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource
) : PhotoRepository {
    override fun getPhotos(): List<Photo> {
        val response = dataSource.getPhotos()
        return response.mapNotNull { PhotoMapper.map(it) }
    }
}