package org.hyunjung.day18.datasource

import day18.dto.PhotoResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import org.hyunjung.day18.util.ApiModule
import org.hyunjung.day18.util.Constants.API_KEY

class PhotoDataSourceImpl(
    private val client: HttpClient = ApiModule.create()
) : PhotoDataSource {
    override suspend fun getPhotos(query: String): PhotoResponse {
        val response =
            client.get("https://pixabay.com/api/?key=${API_KEY}&q=${query}&image_type=photo&pretty=true")

        if (response.status != HttpStatusCode.OK) throw Exception("${response.status.value}: ${response.status.description}")
        return Json.decodeFromString<PhotoResponse>(response.body())
    }
}