package day16.data

interface ImageRepository {
    suspend fun saveImage(url: String, path: String)
    suspend fun saveImage(urls: List<String>, directory: String)
    suspend fun saveImageIfNotExists(url: String, path: String): Boolean
}