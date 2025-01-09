package org.example.day16.repository.image

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.example.day16.data_source.image.ImageDataSource
import org.example.day16.model.image.DownloadInfo
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.abs

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
        val stringBuilder = StringBuilder()
        val format = DateTimeFormatter.ofPattern("hh:mm:ss.SSSSSS")
        val startTime = LocalDateTime.now()
        stringBuilder.append("다운로드 시작\n")
        val bytes = dataSource.fetchImage(url)
        val endTime = LocalDateTime.now()
        dataSource.saveImage(bytes, path)
        val elapsedTime = Duration.between(startTime, endTime)
        stringBuilder.append("다운로드 끝\n=========\n소요시간 : ${formatDuration(elapsedTime)}\n용량 : ${bytes.size} byte\n")
        println(stringBuilder)
        val result = DownloadInfo(
            startTime.format(format),
            endTime.format(format),
            formatDuration(elapsedTime),
            bytes.size.toString()
        )
        result
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

    private fun formatDuration(duration: Duration): String {
        val seconds = duration.seconds
        val absSeconds = abs(seconds)
        val positive = String.format(
            "%02d:%02d:%02d.%06d",
            absSeconds / 3600,
            absSeconds % 3600 / 60,
            absSeconds % 60,
            duration.nano / 1000
        )
        return if (seconds < 0) "-$positive" else positive
    }
}