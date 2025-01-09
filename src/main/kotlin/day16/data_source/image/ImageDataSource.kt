package org.example.day16.data_source.image

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import org.example.day15.data_source.DataSource


interface ImageDataSource : DataSource {
    val client: HttpClient
        get() = HttpClient(CIO)

    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}