package org.example.day16.repository_exam.data_source.image

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}