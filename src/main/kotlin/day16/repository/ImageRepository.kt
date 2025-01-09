package org.example.day16.repository

import org.example.day16.datasource.ImageDataSource
import java.io.File
import java.net.URL

interface ImageRepository {
    suspend fun saveImage(url: String, path: String)
    suspend fun saveImages(urls: List<String>, directory: String)
    suspend fun saveImageIfNotExists(url: String, path: String): Boolean
}

class ImageRepositoryImpl(private val dataSource: ImageDataSource) : ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        // 이미지를 가져와서 저장
        val imageBytes = dataSource.fetchImage(url)
        dataSource.saveImage(imageBytes, path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        for (url in urls) {
            val fileName = URL(url).path.split("/").last() // URL에서 파일 이름 추출
            val filePath = "$directory/$fileName"
            saveImage(url, filePath)
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        val file = File(path)
        return if (file.exists()) {
            false // 파일이 이미 존재하면 저장하지 않고 false 반환
        } else {
            saveImage(url, path) // 파일이 없으면 저장
            true
        }
    }
}