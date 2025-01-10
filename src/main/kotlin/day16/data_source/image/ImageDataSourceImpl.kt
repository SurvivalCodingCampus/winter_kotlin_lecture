package org.example.day16.data_source.image

import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.io.File

class ImageDataSourceImpl : ImageDataSource {

    override suspend fun fetchImage(url: String): ByteArray = client.get(url).bodyAsBytes()


    override suspend fun saveImage(bytes: ByteArray, path: String) = File(path).writeBytes(bytes)
}