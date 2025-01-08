package org.example.day16.repository_exam.repository.image

import org.example.day16.repository_exam.data_source.image.ImageDataSource
import java.io.File

class ImageRepositoryImpl(private val dataSource: ImageDataSource) : ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        dataSource.saveImage(dataSource.fetchImage(url), path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        // 디렉토리는 root에 있는 디렉토리라고 가정
        val path = "${directory}/도지1"

        for (i: Int in 1..urls.size) {
            saveImageIfNotExists(urls[i - 1], path + "${i}.txt")
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        if (!File(path).exists()) {
            dataSource.saveImage(dataSource.fetchImage(url), path)
            return true
        } else {
            return false
        }
    }
}