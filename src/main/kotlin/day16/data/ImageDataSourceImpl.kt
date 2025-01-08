package day16.data

class ImageDataSourceImpl : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        TODO("Not yet implemented")
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        TODO("Not yet implemented")
    }
}