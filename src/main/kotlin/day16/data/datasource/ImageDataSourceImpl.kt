package org.example.day16.data.datasource

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.File

class ImageDataSourceImpl(
    private val httpClient: HttpClient = HttpClient(CIO)
) : ImageDataSource {
    override suspend fun fetchImage(url: String): Flow<ByteArray> = flow {
        emit(httpClient.get(url).body<ByteArray>())
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        var fileName = "img.png"
        var number = 1
        val file = File(path)
        if (!file.exists()) {
            file.mkdirs()
        }
        while (File("$path/$fileName").exists()) {
            number += 1
            fileName = "img($number).png"
        }

        File("$path/$fileName").writeBytes(bytes)
    }
}