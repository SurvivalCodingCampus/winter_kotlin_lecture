package org.hyunjung.day16.image.repository

import org.hyunjung.day16.image.datasource.ImageDataSource
import org.hyunjung.day16.image.model.DownloadInfo
import java.io.File
import kotlin.time.measureTime

class ImageDownloadRepositoryImpl(
    private val dataSource: ImageDataSource
) : ImageDownloadRepository {

    override suspend fun saveImage(url: String, path: String): DownloadInfo {
        println("다운로드 시작")
        val elapsedTime = measureTime {
            val imageBytes = dataSource.fetchImage(url)
            dataSource.saveImage(imageBytes, path)
        }
        println("다운로드 끝")

        val fileSize = getFileSizeInBytes(File(path))
        println("=========")
        println("소요시간 : ${elapsedTime}")
        println("용량 : ${fileSize}bytes")
        println("=========")

        return DownloadInfo(
            startTime = "N/A", // 시작 시간과 종료 시간은 생략
            endTime = "N/A",
            elapsedTime = elapsedTime.toString(),
            fileSize = "$fileSize bytes"
        )
    }

    override suspend fun saveImages(urls: List<String>, directory: String): List<DownloadInfo> {
        val results = mutableListOf<DownloadInfo>()
        urls.forEachIndexed { index, url ->
            val path = "$directory/image_$index.jpg"
            results.add(saveImage(url, path))
        }
        return results
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo {
        val file = File(path)
        return if (!file.exists()) {
            saveImage(url, path)
        } else {
            val fileSize = getFileSizeInBytes(file)
            println("이미 파일이 존재합니다.")
            println("=========")
            println("용량 : ${fileSize}bytes")
            println("=========")

            DownloadInfo(
                startTime = "N/A",
                endTime = "N/A",
                elapsedTime = "0ms",
                fileSize = "$fileSize bytes"
            )
        }
    }

    // 파일 크기를 바이트 단위로 반환
    private fun getFileSizeInBytes(file: File): Long {
        return if (file.exists()) file.length() else 0L
    }
}