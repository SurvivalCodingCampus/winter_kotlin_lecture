package org.example.day16.data.datasource

import kotlinx.coroutines.flow.Flow

interface ImageDataSource {
    suspend fun fetchImage(url: String): Flow<ByteArray>
    suspend fun saveImage(bytes: ByteArray, path: String)
}