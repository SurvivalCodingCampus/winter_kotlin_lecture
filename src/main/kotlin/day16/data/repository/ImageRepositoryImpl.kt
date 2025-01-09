package org.example.day16.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.data.result.Result
import org.example.day14.data.result.asResult
import org.example.day16.data.datasource.ImageDataSource
import org.example.day16.data.model.DownloadInfo
import java.io.File
import java.nio.file.FileAlreadyExistsException

class ImageRepositoryImpl(
    private val imageDataSource: ImageDataSource
) : ImageRepository {
    override suspend fun saveImage(url: String, path: String): Flow<DownloadInfo> = flow {
        val startTime = System.currentTimeMillis()
        imageDataSource.fetchImage(url).collect { bytes ->
            imageDataSource.saveImage(bytes, path)
            val endTime = System.currentTimeMillis()
            emit(
                DownloadInfo(
                    startTime.toString(),
                    endTime.toString(),
                    (endTime - startTime).toString(),
                    "${bytes.size}bytes"
                )
            )
        }
    }

    override suspend fun saveImages(urls: List<String>, directory: String): Flow<List<DownloadInfo>> = flow {
        val downloads = mutableListOf<DownloadInfo>()

        urls.forEach { url ->
            saveImage(url, directory).asResult()
                .collect { result ->
                    if (result is Result.Success) {
                        downloads.add(result.data)
                    }
                }
        }
        emit(downloads)
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Flow<DownloadInfo?> = flow {
        if (File(path).exists()) {
            throw FileAlreadyExistsException(path)
        } else {
            saveImage(url, path).collect {
                emit(it)
            }
        }
    }
}