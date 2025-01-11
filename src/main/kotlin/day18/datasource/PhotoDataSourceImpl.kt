package org.example.day18.datasource

import day18.dto.PhotoDto
import day18.dto.PhotoResponse
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import org.example.day18.util.Config

class PhotoDataSourceImpl : PhotoDataSource {
    private val baseUrl = "https://pixabay.com/api/"
    private val apiKey = Config.apiKey
    private val httpClient: HttpClient = HttpClient(CIO)

    override suspend fun getPhotos(query: String): List<PhotoDto> {
        val response = httpClient.get(baseUrl) {
            url {
                parameters.append("key", apiKey)
                parameters.append("q", query)
                parameters.append("image_type", "photo") // 이미지 타입 필터
                parameters.append("per_page", "20") // 페이지당 결과 수
            }
        }

        // JSON 응답 문자열
        val responseBody = response.bodyAsText()

        // 응답 데이터를 디코딩
        val photoResponse: PhotoResponse = Json { ignoreUnknownKeys = true }
            .decodeFromString(responseBody)

        return photoResponse.hits
    }
}