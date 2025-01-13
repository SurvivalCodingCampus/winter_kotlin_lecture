package org.example.day18.data_source

import day18.dto.PhotoDto
import day18.dto.PixabayResponseDto
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.example.day15.data_source.KtorClient
import org.example.day18.error.PhotoError
import org.example.day18.model.PhotoOrder

class PhotoDataSourceImpl(override val baseUrl: String, override val client: HttpClient, val pixabayApiKey: String) :
    PhotoDataSource, KtorClient {

    override suspend fun getPhotos(query: String, order: PhotoOrder): List<PhotoDto> {
        val response = client.get("$baseUrl/?key=$pixabayApiKey&q=$query&order=${order.value}")
        if (response.status == HttpStatusCode.InternalServerError) {
            throw PhotoError.ServerError(response.bodyAsText())
        }
        if (response.status.value in 400..499) {
            throw PhotoError.NetworkError
        }
        return defaultJson.decodeFromString<PixabayResponseDto>(
            response
                .bodyAsText()
        ).hits ?: emptyList()
    }

}