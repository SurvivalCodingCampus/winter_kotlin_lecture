package org.example.day16.repository.image

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.example.day16.data_source.image.ImageDataSource
import org.example.day16.model.image.DownloadInfo
import java.time.LocalDateTime

class ImageRepositoryImpl(override val dataSource: ImageDataSource) : ImageRepository {

    override suspend fun saveImage(url: String, path: String) = withContext(Dispatchers.IO) {
        try {
            val bytes = dataSource.fetchImage(url)
            dataSource.saveImage(bytes, path)
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun saveImages(urls: List<String>, directory: String) = withContext(Dispatchers.IO) {
        try {
            val fileName = urls.map { it.substringAfterLast("/") }
            urls.forEachIndexed { index, url ->
                val path = "$directory/${index}_${fileName[index]}"
                saveImage(url, path)
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean = withContext(Dispatchers.IO) {
        try {
            val file = java.io.File(path)
            if (file.exists()) {
                false
            } else {
                saveImage(url, path)
                true
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun saveImageAndReturnDownloadInfo(
        url: String,
        path: String
    ): DownloadInfo = withContext(Dispatchers.IO) {
        val startTime = LocalDateTime.now()
        val bytes = dataSource.fetchImage(url)
        val endTime = LocalDateTime.now()
        dataSource.saveImage(bytes, path)
        val elapsedTime = endTime.minusNanos(startTime.nano.toLong())
        DownloadInfo(startTime.toString(), endTime.toString(), elapsedTime.toString(), bytes.size.toString())
    }

    override suspend fun saveImagesAndReturnDownloadInfo(
        urls: List<String>,
        directory: String
    ): List<DownloadInfo> = withContext(Dispatchers.IO) {
        urls.mapIndexed { index, url ->
            val fileName = url.substringAfterLast("/")
            val path = "$directory/${index}_$fileName"
            saveImageAndReturnDownloadInfo(url, path)
        }
    }

    override suspend fun saveImageIfNotExistsAndReturnDownloadInfo(
        url: String,
        path: String
    ): DownloadInfo? = withContext(Dispatchers.IO) {
        val file = java.io.File(path)
        if (file.exists()) {
            null
        } else {
            saveImageAndReturnDownloadInfo(url, path)
        }
    }
}