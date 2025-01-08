package day16.data

class ImageRepositoryImpl(private val source: ImageDataSource) : ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        TODO("Not yet implemented")
    }

    override suspend fun saveImage(urls: List<String>, directory: String) {
        TODO("Not yet implemented")
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        TODO("Not yet implemented")
    }
}