package com.survivalcoding.com.survivalcoding.day16

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,

    @SerialName("release_date")
    val releaseDate: String,
)

@Serializable
data class UpcomingMovie(
    val results: List<Movie>
)

interface MovieDataSource {
    suspend fun getUpcomingMovies(): List<Movie>
}

interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}

class MovieDataSourceImpl : MovieDataSource {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    override suspend fun getUpcomingMovies(): List<Movie> {
        HttpClient(CIO).use { client ->
            val response =
                client.get("https://api.themoviedb.org/3/movie/upcoming?api_key=a64533e7ece6c72731da47c9c8bc691f&language=ko-KR&page=1")
            val movieInfo = json.decodeFromString<UpcomingMovie>(response.bodyAsText())
            return movieInfo.results
        }
    }

}

class MovieRepositoryImpl(
    private val dataSource: MovieDataSource,
) : MovieRepository {

    override suspend fun getMovieInfoList(): List<Movie> {
        return dataSource.getUpcomingMovies()
    }
}