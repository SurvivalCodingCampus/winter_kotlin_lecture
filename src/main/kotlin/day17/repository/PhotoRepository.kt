package org.example.day17.repository

import org.example.day17.datasource.PhotoDataSource
import org.example.day17.model.Photo

interface PhotoRepository {
    suspend fun getPhots(): List<Photo>
}

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhots(): List<Photo> {
        val dtos = dataSource.getPhots()
        return dtos.map { PhotoMapper.mapToModel(it) }
    }
}