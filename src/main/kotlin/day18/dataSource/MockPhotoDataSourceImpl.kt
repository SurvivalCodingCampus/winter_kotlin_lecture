package day18.dataSource

import PhotoDto
import PhotoResponse
import day18.util.PhotoError
import day18.util.Sample.TEST_URL
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class MockPhotoDataSourceImpl(private val client: HttpClient): PhotoDataSource {
    override suspend fun getPhoto(query: String): List<PhotoDto> {

        val response: HttpResponse = client.get(TEST_URL)
        if (response.status == HttpStatusCode.InternalServerError) {
            throw Exception(PhotoError.ServerError("server error"))
        }

        val responseBody = response.bodyAsText() // json이 string으로 변환
        println(responseBody)
        val result = Json.decodeFromString<PhotoResponse>(responseBody)

        return result.hits ?: emptyList()
    }

}