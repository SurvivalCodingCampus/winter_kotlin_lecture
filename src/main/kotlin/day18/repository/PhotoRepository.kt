package org.example.day18.repository

import org.example.day18.data_source.PhotoDataSource
import org.example.day18.model.Photo
import org.example.day18.model.PhotoOrder
import org.example.day18.util.Result

interface PhotoRepository {
    val dataSource: PhotoDataSource
    suspend fun getPhotos(query: String, order: PhotoOrder = PhotoOrder.LATEST): Result<List<Photo>>
}