package org.hyunjung.day16.image.datasource

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}