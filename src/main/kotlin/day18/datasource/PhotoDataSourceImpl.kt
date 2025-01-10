package day18.datasource

import day16.util.HttpClientFactory
import day18.dto.ImageResponse
import day18.dto.PhotoDto
import day18.utils.Const
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json


class PhotoDataSourceImpl : PhotoDataSource {
    override suspend fun getPhotos(query: String): List<PhotoDto> = withContext(Dispatchers.IO) {

        val data = HttpClientFactory.client.get(Const.BASE_URL) {
            url {
                parameters.append("q", query)
            }
        }.bodyAsText()

        val result = Json.decodeFromString<ImageResponse>(data)
        return@withContext result.hits ?: emptyList()
    }

}