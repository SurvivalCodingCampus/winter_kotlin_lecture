package com.survivalcoding.com.survivalcoding.day16

import kotlinx.coroutines.runBlocking
import java.io.File

data class DownloadInfo(
    val startTime: String,
    val endTime: String,
    val elapsedTime: String,
    val fileSize: String,
)

interface ImageRepository2 {
    // URL에서 이미지를 다운로드하여 지정된 경로에 저장
    suspend fun saveImage(url: String, path: String): DownloadInfo

    // 여러 URL의 이미지들을 지정된 디렉토리에 저장
    suspend fun saveImages(urls: List<String>, directory: String): List<DownloadInfo>

    // 이미지가 존재하지 않는 경우에만 URL에서 다운로드하여 저장
    suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo?
}

class ImageRepositoryImpl2(
    private val dataSource: ImageDataSource
) : ImageRepository2 {

    override suspend fun saveImage(url: String, path: String): DownloadInfo {
        val startTime = System.currentTimeMillis()

        val bytes = dataSource.fetchImage(url)
        dataSource.saveImage(bytes, path)

        val endTime = System.currentTimeMillis()
        val elapsedTime = endTime - startTime

        return DownloadInfo(
            startTime = startTime.toString(),
            endTime = endTime.toString(),
            elapsedTime = elapsedTime.toString(),
            fileSize = bytes.size.toString(),
        )
    }

    override suspend fun saveImages(urls: List<String>, directory: String): List<DownloadInfo> {
//        val path = Path(directory)
        val file = File(directory)
        if (!file.exists()) {
            file.mkdirs()
        }

        return urls.mapIndexed { index, url ->
            saveImage(url, "$directory/$index.png")
        }

    }

    override suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo? {
        if (File(path).exists()) {
            return null
        }

        return saveImage(url, path)
    }

}

fun main(): Unit = runBlocking {
    val repository = ImageRepositoryImpl2(ImageDataSourceImpl())

    println("다운로드 시작")
    val result = repository.saveImage(
        "https://i.namu.wiki/i/WVtD0ZPmoZ8Q3rOnWwjjhj7GNeghCXcy-pzDd15U4xbakNmmXu-IhHszT8aOrP3ulRlb6Rd4oJy1jpYZ_XzflBTZoV1AGW8TIdkrliE0nylY2qb_aSKExirXx1pN-CtdL3VEpHzWXhxmp-ijJks9FQ.webp",
        "qwer.png"
    )

    println("다운로드 끝")
    println("=========")
    println("소요시간 : ${(result.elapsedTime.toDouble() % 60000) / 1000}")
    println("용량 : ${result.fileSize}bytes")
}