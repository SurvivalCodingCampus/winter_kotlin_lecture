package org.hyunjung.day16.image.repository

import org.hyunjung.day16.image.datasource.ImageDataSource
import java.io.File

class ImageRepositoryImpl(
    private val dataSource: ImageDataSource
) : ImageRepository {

    override suspend fun saveImage(url: String, path: String) {
        val imageBytes = dataSource.fetchImage(url)
        dataSource.saveImage(imageBytes, path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        urls.forEachIndexed { index, url ->
            val path = "$directory/image_$index.jpg"
            saveImage(url, path)
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        val file = File(path)
        return if (!file.exists()) {
            saveImage(url, path)
            true
        } else {
            false
        }
    }
}