package day18.dataSource

import PhotoDto
import PhotoResponse
import day18.util.PhotoError
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class PhotoDataSourceImpl(private val client: HttpClient): PhotoDataSource {
    private val baseUrl = "https://pixabay.com/api/"

    override suspend fun getPhoto(query: String): List<PhotoDto> {
        val response: HttpResponse = client.get(baseUrl) {
            parameter ("q", query)
        }

        val responseBody = response.bodyAsText() // json이 string으로 변환
        println(responseBody)
        val result = Json.decodeFromString<PhotoResponse>(responseBody)

        return result.hits ?: emptyList()   // Elvis 연산자 : null아니면 앞에거 반환, null이면 뒤에거 반환
    }
}

fun main(): Unit = runBlocking {
    val test = PhotoDataSourceImpl(HttpClient(CIO))
    test.getPhoto("yellow")
}






















