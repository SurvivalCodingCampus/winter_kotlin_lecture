package org.example.day16.repository.image

import org.example.day16.data_source.image.ImageDataSource

interface ImageRepository {
    val dataSource: ImageDataSource
    suspend fun saveImage(url: String, path: String)

    suspend fun saveImages(urls: List<String>, directory: String)

    suspend fun saveImageIfNotExists(url: String, path: String): Boolean
}