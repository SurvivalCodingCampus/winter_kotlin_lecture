package org.example.day16.datasource

import day16.model.Movie
import day16.model.UpcomingMoviesResponse
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import org.example.day16.HttpClientFactory

interface MovieDataSource {
    suspend fun getUpcomingMovies(): List<Movie>
}

class MovieDataSourceImpl : MovieDataSource {
    private val httpClient = HttpClientFactory.create()
    override suspend fun getUpcomingMovies(): List<Movie> {
        val response =
            httpClient.get("https://api.themoviedb.org/3/movie/upcoming?api_key=a64533e7ece6c72731da47c9c8bc691f&language=ko-KR&page=1")
        val responseBody = response.bodyAsText()
        val upcomingMoviesResponse: UpcomingMoviesResponse =
            Json { ignoreUnknownKeys = true }.decodeFromString(responseBody)

        return upcomingMoviesResponse.results
    }
}

class MovieMockDataSourceImpl : MovieDataSource {
    override suspend fun getUpcomingMovies(): List<Movie> {
        val json = """
            [
                {
                    "id": 939243,
                    "title": "수퍼 소닉 3",
                    "overview": "너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...",
                    "release_date": "2024-12-19"
                }
            ]
        """.trimIndent()

        return Json.decodeFromString<List<Movie>>(json)

    }
}