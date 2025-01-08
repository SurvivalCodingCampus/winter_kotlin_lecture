package day16

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

// 요청 할때마다 만들지 말고, object로 싱글턴으로 만들기
object HttpClientFactory {
    fun create():HttpClient = HttpClient(CIO)
}

fun main() = runBlocking {
    val httpClient = HttpClientFactory.create()
    val response = httpClient.get("https://api.themoviedb.org/3/movie/upcoming?api_key=a64533e7ece6c72731da47c9c8bc691f&language=ko-KR&page=1")
    println(response.bodyAsText())
}