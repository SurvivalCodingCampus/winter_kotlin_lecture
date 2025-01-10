package day18.datasource

import day18.dto.ImageResponse
import day18.dto.PhotoDto
import day18.utils.Const
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class MockPhotoDataSourceImpl(
    private val client: HttpClient
) : PhotoDataSource {
    override suspend fun getPhotos(query: String): List<PhotoDto> = withContext(Dispatchers.IO) {
        val data = client.get(Const.TEST_BASE_URL) {}

        // 상태 코드가 200이면 정상 데이터를 반환
        if (data.status == HttpStatusCode.OK) {
            val responseBody = data.bodyAsText()
            return@withContext Json.decodeFromString<ImageResponse>(responseBody).hits ?: emptyList()
        } else {
            throw ServerResponseException(data, "")
        }
    }
}
