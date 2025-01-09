package day16.data

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.io.path.Path

class ImageDataSourceImpl : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray = withContext(Dispatchers.IO) {
        Data.client.get(url).bodyAsBytes()
    }


    override suspend fun saveImage(bytes: ByteArray, path: String) = withContext(Dispatchers.IO) {
        Path(path).toFile().writeBytes(bytes)
    }
}