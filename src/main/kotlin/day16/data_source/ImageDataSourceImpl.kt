import org.example.day16.utils.HttpClientFactory
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.io.File

val imageUrl =
    "https://i.namu.wiki/i/uuV6HrKsXMGw7lQ7zLfdYN9e7Prx7hg9sT-gFzfy1JRxTItemFHeack_817SU5sX_bh7D5JsGT3MZv37qzuJlm2C-oEPlsIXar_ApkFqAtH5ocXp-0L5qe1qcYNSu_SHA4mHXJ6Y46-DQXTlrcYXbQ.webp"

class ImageDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : ImageDataSource {

    override suspend fun fetchImage(url: String): ByteArray {
        val response = client.get(imageUrl)
        val imageStore = response.bodyAsBytes()

        return imageStore
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        val newFile = File(path)
        newFile.writeBytes(bytes)
    }
}
