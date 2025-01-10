package org.example.day18.datasource

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import org.example.day14.util.jsonConfig
import org.example.day18.dto.PixabayResponse
import org.example.day18.dto.asExternalModel
import org.example.day18.model.Photo

class PixabayDataSource(
    private val httpClient: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(jsonConfig)
        }
    },
    private val apiKey: String,
) : PhotoDataSource {
    private val pixabayUrl = "https://pixabay.com/api/"
    override suspend fun getPhotos(query: String): List<Photo> =
        httpClient.get(pixabayUrl) {
            url {
                parameters.append("key", apiKey)
                parameters.append("q", query)
            }
        }.body<PixabayResponse>().hits.map { it.asExternalModel() }
}
