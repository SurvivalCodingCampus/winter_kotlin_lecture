package org.hyunjung.day16.image.datasource

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.io.File

class ImageDataSourceImpl(
    private val client: HttpClient
) : ImageDataSource {

    override suspend fun fetchImage(url: String): ByteArray {
        return client.get(url).bodyAsBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        File(path).writeBytes(bytes)
    }
}