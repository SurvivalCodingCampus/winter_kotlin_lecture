package day16.repository

import day16.data_source.ImageDataSource
import java.io.File

class ImageRepositoryImpl(private val dataSource: ImageDataSource) : ImageRepository {

    override suspend fun saveImage(url: String, path: String) {
        dataSource.saveImage(dataSource.fetchImage(url), path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        for ((index, url) in urls.withIndex()) {
            val fileName = "image_${index + 1}.jpg"
            val path = "$directory/$fileName"
            dataSource.saveImage(dataSource.fetchImage(url), path)
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        // 이미지 존재 false
        if (File(path).exists()) {
            return false
        }

        // 이미지 존재X, 다운로드 후 저장 true
        dataSource.saveImage(dataSource.fetchImage(url), path)
        return true
    }

}