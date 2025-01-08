package day16.data_source

import day16.HttpClientFactory
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class ImageDataSourceImpl(private val client: HttpClient = HttpClient(CIO)) : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray = withContext(Dispatchers.IO) {
        client.get(url).bodyAsBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) = withContext(Dispatchers.IO) {
        File(path).writeBytes(bytes)
    }
}