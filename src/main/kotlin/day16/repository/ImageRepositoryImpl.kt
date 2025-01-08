package day16.repository

import day16.data_source.ImageDataSource
import day16.model.DownloadInfo
import java.io.File

class ImageRepositoryImpl(private val dataSource: ImageDataSource) : ImageRepository {

    override suspend fun saveImage(url: String, path: String): DownloadInfo {
        val startTime = System.currentTimeMillis()

        try {
            dataSource.saveImage(dataSource.fetchImage(url), path)
        } catch (e: Exception) {
            throw e
        }

        val endTime = System.currentTimeMillis()
        val elapsedTime = endTime - startTime // 경과 시간

        // 다운로드한 파일의 크기를 계산
        val fileSize = try {
            File(path).length().toString()
        } catch (e: Exception) {
            "0"
        }

        return DownloadInfo(
            startTime = startTime.toString(),
            endTime = endTime.toString(),
            elapsedTime = elapsedTime.toString(),
            fileSize = fileSize
        )
    }

    override suspend fun saveImages(urls: List<String>, directory: String): List<DownloadInfo> {
        val downloadInfoList = mutableListOf<DownloadInfo>()

        for ((index, url) in urls.withIndex()) {
            val fileName = "image_${index + 1}.jpg"
            val path = "$directory/$fileName"

            // 다운로드 및 다운로드 정보 생성
            val downloadInfo = saveImage(url, path)
            downloadInfoList.add(downloadInfo)
        }

        return downloadInfoList
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo? {
        // 이미지 존재
        if (File(path).exists()) {
            return null
        }

        // 이미지 존재X, 다운로드 후 저장 true
        try {
            dataSource.saveImage(dataSource.fetchImage(url), path)
            return saveImage(url, path) // DownloadInfo 반환
        } catch (e: Exception) {
            throw e
        }
    }

}