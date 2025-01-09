package org.example.day16.repository

import DownloadInfo

interface ImageRepository {
    suspend fun saveImage(url: String, path: String): Double
    suspend fun saveImages(urls: List<String>, directory: String)
    suspend fun saveImageIfNotExists(urls: String, path: String): DownloadInfo?
}
