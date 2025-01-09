package org.example.day16.repository_exam.data_source.image

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.io.File

class ImageDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO),
) : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        return client.get(url).bodyAsBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        File(path).writeBytes(bytes)
    }
}