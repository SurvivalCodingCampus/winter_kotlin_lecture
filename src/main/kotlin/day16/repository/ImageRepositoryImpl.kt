package day16.repository

import day16.dataSource.ImageDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.io.File

class ImageRepositoryImpl(private val imageDataSource: ImageDataSource): ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        try {
            val bytes = imageDataSource.fetchImage(url)     // 이미지 다운로드
            imageDataSource.saveImage(bytes, path)                    // 파일 시스템에 저장
        } catch (e: Exception) {
            println(e.message)
        }


    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        withContext(Dispatchers.IO) {
            val dir = File(directory)
            if (!dir.exists()) {
                dir.mkdirs()    // 디렉토리 없으면 생성
            }
            val imageSave = urls.mapIndexed { index, url ->
                val path = "$directory/image_$index.jpg"    //파일 경로 생성
                async {
                    saveImage(url, path)
                }
            }
            imageSave.forEach { it.await() }
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        return if (!File(path).exists()) {
            saveImage(url, path)
            true    // 이미지가 다운로드 되어 저장됨
        } else {
            false   // 이미지가 이미 존재하니 다운로드 하지 않음
        }
    }
}