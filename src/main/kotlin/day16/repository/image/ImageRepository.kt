package org.example.day16.repository.image

import org.example.day16.data_source.image.ImageDataSource
import org.example.day16.model.image.DownloadInfo

interface ImageRepository {
    val dataSource: ImageDataSource
    suspend fun saveImage(url: String, path: String)

    suspend fun saveImages(urls: List<String>, directory: String)

    suspend fun saveImageIfNotExists(url: String, path: String): Boolean

    suspend fun saveImageAndReturnDownloadInfo(url: String, path: String): DownloadInfo

    suspend fun saveImagesAndReturnDownloadInfo(urls: List<String>, directory: String): List<DownloadInfo>

    suspend fun saveImageIfNotExistsAndReturnDownloadInfo(url: String, path: String): DownloadInfo?
}