package day16.data

import io.ktor.http.*
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString
import kotlin.io.path.exists
import kotlin.io.path.isDirectory
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ImageRepositoryImpl(private val source: ImageDataSource) : ImageRepository {
    override suspend fun saveImage(url: String, path: String) {
        val fetched = source.fetchImage(url)
        source.saveImage(fetched, path)
    }

    @OptIn(ExperimentalUuidApi::class)
    override suspend fun saveImage(urls: List<String>, directory: String) {
        val destination = Path(directory)
        require(destination.isDirectory())

        urls.forEach {
            val ext = Url(it).encodedPath.split('.').last()
            val fileName = "${Uuid.random()}.${ext}"
            saveImage(it, destination.resolve(fileName).absolutePathString())
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean {
        if (Path(path).exists()) return false
        saveImage(url, path)
        return true
    }
}