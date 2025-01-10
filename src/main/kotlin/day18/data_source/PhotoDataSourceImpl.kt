package day18.data_source

import day18.dto.PhotoDto
import day18.dto.PhotoResponse
import day18.utils.ApiConfig
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class PhotoDataSourceImpl(
    private val apiKey: String = ApiConfig.load(),
    private val client: HttpClient = HttpClient(CIO)
) : PhotoDataSource {
    companion object {
        const val BASE_URL =
            "https://pixabay.com/api/"
        const val SEARCH_TYPE = "photo"
    }

    override suspend fun getPhotoList(keyword: String): List<PhotoDto> {

        return client.use { httpClient ->
            try {
                val response: HttpResponse = httpClient.get(BASE_URL) {
                    parameter("key", apiKey)
                    parameter("q", keyword)
                    parameter("image_type", SEARCH_TYPE)
                }

                if (response.status == HttpStatusCode.OK) {
                    val responseBody = response.bodyAsText()
                    val photoResult = Json.decodeFromString<PhotoResponse>(responseBody)

                    if (photoResult.hits == null) {
                        return emptyList()
                    }

                    return photoResult.hits
                } else {
                    // 상태 코드가 OK가 아닌 경우 예외 처리
                    throw Exception("Failed to load photos. Status: ${response.status}")
                }

            } catch (e: Exception) {
                throw Exception("Error during API request: ${e.message}", e)
            }
        }
    }

}
