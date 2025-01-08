import org.example.day16.repository.ImageRepository
import java.io.File

class ImageRepositoryImpl(
    private val imageDataSource: ImageDataSource,
    private val basePath: String = "./src/main/kotlin/day16/downloads/"
) : ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        val bytes = imageDataSource.fetchImage(url)
        val fullPath = "$basePath$path"
        imageDataSource.saveImage(bytes, fullPath)
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        urls.forEachIndexed { index, url ->
            val path = "$directory/image_$index.jpg"
            saveImage(url, path)
        }
    }

    override suspend fun saveImageIfNotExists(urls: String, path: String): Boolean {
        val fullPath = "$basePath$path"
        return if (!File(fullPath).exists()) {
            saveImage(url, path)
            true
        } else {
            false
        }
    }

}
