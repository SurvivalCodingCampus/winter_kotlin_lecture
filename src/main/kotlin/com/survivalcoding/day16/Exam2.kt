package com.survivalcoding.com.survivalcoding.day16

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import java.io.File

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}

class ImageDataSourceImpl : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        HttpClient(CIO).use { client ->
            val response = client.get(url)
            return response.bodyAsBytes()
        }
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        File(path).writeBytes(bytes)
    }

}

interface ImageRepository {
    // URL에서 이미지를 다운로드하여 지정된 경로에 저장
    suspend fun saveImage(url: String, path: String)

    // 여러 URL의 이미지들을 지정된 디렉토리에 저장
    suspend fun saveImages(urls: List<String>, directory: String)

    // 이미지가 존재하지 않는 경우에만 URL에서 다운로드하여 저장
    suspend fun saveImageIfNotExists(url: String, path: String): Boolean
}

class ImageRepositoryImpl(
    private val dataSource: ImageDataSource
) : ImageRepository {

    override suspend fun saveImage(url: String, path: String) {
        val bytes = dataSource.fetchImage(url)
        dataSource.saveImage(bytes, path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
//        val path = Path(directory)
        val file = File(directory)
        if (!file.exists()) {
            file.mkdirs()
        }

        urls.forEachIndexed { index, url ->
            saveImage(url, "$directory/$index.png")
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        if (File(path).exists()) {
            return false
        }

        saveImage(url, path)
        return true
    }

}

fun main(): Unit = runBlocking {
    val repository = ImageRepositoryImpl(
        ImageDataSourceImpl()
    )

//    repository.saveImage("https://wimg.mk.co.kr/news/cms/202310/18/news-p.v1.20231018.46f31f9d8f5f4c70884b8ff4b2ca40d8_P1.jpg", "qwer.jpg")
    repository.saveImages(
        listOf(
            "https://wimg.mk.co.kr/news/cms/202310/18/news-p.v1.20231018.46f31f9d8f5f4c70884b8ff4b2ca40d8_P1.jpg",
            "https://i.namu.wiki/i/WVtD0ZPmoZ8Q3rOnWwjjhj7GNeghCXcy-pzDd15U4xbakNmmXu-IhHszT8aOrP3ulRlb6Rd4oJy1jpYZ_XzflBTZoV1AGW8TIdkrliE0nylY2qb_aSKExirXx1pN-CtdL3VEpHzWXhxmp-ijJks9FQ.webp",
            "https://external-preview.redd.it/gfriend-to-release-a-special-album-on-january-13-2025-a-pre-v0-D2vvHR50_T1GIoWkDr1ncLSfea4tJp1A8J7vJhA2W44.jpg?width=1080&crop=smart&auto=webp&s=122ec092407647760ef2043ce8ba65ec7d99b56e"
        ), "image"
    )


}