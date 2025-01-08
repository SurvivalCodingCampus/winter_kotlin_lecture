package day16.data_source

import day16.HttpClientFactory
import day16.model.Movie
import day16.model.Movies
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class MovieDataSourceImpl:MovieDataSource {
    private val format = Json { ignoreUnknownKeys = true}
    private val httpClient = HttpClientFactory.create()
    private val urlString = "https://api.themoviedb.org/3/movie/upcoming?api_key=a64533e7ece6c72731da47c9c8bc691f&language=ko-KR&page=1"

    override suspend fun getUpcomingMovies(): List<Movie> {
        val response = httpClient.get(urlString).bodyAsText()

        return try {
            // 전체 응답을 파싱하고 results 필드만 추출
            val moviesData = format.decodeFromString<Movies>(response)
            moviesData.results // results 필드만 반환
        } catch (e: Exception) {
            println("Error: ${e.message}")
            // 오류 발생 시 빈 리스트 반환
            emptyList()
        }
    }
}
