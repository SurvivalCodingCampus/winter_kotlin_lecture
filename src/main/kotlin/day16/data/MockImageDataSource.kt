package day16.data

import kotlinx.coroutines.delay
import kotlin.io.path.Path

class MockImageDataSource(private val delayAmount: Long) : ImageDataSource {
    val mockImage = Path("src/main/kotlin/day16/data/img.png").toFile()
    override suspend fun fetchImage(url: String): ByteArray {
        delay(delayAmount)
        return mockImage.readBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
    }
}