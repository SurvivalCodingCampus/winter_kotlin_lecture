package org.example.day16.data_source.image

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class ImageDataSourceImpl : ImageDataSource {

    override suspend fun fetchImage(url: String): ByteArray = withContext(Dispatchers.IO) {
        try {
            client.get(url).bodyAsBytes()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) = withContext(Dispatchers.IO) {
        try {
            File(path).writeBytes(bytes)
        } catch (e: Exception) {
            throw e
        }
    }
}