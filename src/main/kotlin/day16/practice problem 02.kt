package day16

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.io.File

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}

interface ImageRepository {
    suspend fun saveImage(url: String, path: String)
    suspend fun saveImages(urls: List<String>, directory: String)
    suspend fun saveImageIfNotExists(url: String, path: String): Boolean
}

class ImageDataSourceImpl: ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        val client = HttpClient { HttpClient(CIO) }

        return client.get(url).bodyAsBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        val file = File(path)
        file.writeBytes(bytes)
        //file.delete()
    }
}

class ImageRepositoryImpl(private val dataSource: ImageDataSource): ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        dataSource.saveImage(dataSource.fetchImage(url), path)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        for(i in urls.indices) {
            dataSource.saveImage(dataSource.fetchImage(urls[i]), directory)
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        if(File(path).isFile()) {
            println("파일이 이미 존재합니다.")
            return false
        }

        saveImage(url, path)
        return true
    }
}