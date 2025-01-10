package org.example.day16.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}

class ImageDataSourceImpl : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        return URL(url).readBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        val filePath: Path = Paths.get(path)
        withContext(Dispatchers.IO) {
            Files.createDirectories(filePath.parent)
        }
        withContext(Dispatchers.IO) {
            Files.write(filePath, bytes)
        }
    }
}