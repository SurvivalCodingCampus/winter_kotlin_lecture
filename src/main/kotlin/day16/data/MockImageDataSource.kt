package day16.data

import kotlin.io.path.Path

class MockImageDataSource() : ImageDataSource {
    val mockImage = Path("src/main/kotlin/day16/data/img.png").toFile()
    override suspend fun fetchImage(url: String): ByteArray {
        return mockImage.readBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
    }
}