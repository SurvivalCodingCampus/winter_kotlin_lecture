package org.example.day16.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day16.data.model.DownloadInfo

interface ImageRepository {
    suspend fun saveImage(url: String, path: String): Flow<DownloadInfo>
    suspend fun saveImages(urls: List<String>, directory: String): Flow<List<DownloadInfo>>
    suspend fun saveImageIfNotExists(url: String, path: String): Flow<DownloadInfo?>
}