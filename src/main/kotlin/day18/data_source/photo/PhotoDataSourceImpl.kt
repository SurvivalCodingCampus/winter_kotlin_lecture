package org.example.day18.data_source.photo

import io.github.cdimascio.dotenv.dotenv
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import org.example.day18.dto.photo.PhotoDto
import org.example.day18.dto.photo.PhotoResult

class PhotoDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO),
) : PhotoDataSource {
    private val dotEnv = dotenv()["PIXABAY_API_KEY"] ?: throw IllegalStateException("API Key not found")
    private val url: String = "https://pixabay.com/api/?key=${dotEnv}&q="

    override suspend fun getPhotos(query: String): List<PhotoDto> {
        val data = Json.decodeFromString<PhotoResult>(client.get("$url$query").bodyAsText()).hits

        if (data != null) return data

        return emptyList()
    }
}