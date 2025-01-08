package org.example.day16.data_source.movie

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.example.day15.data_source.KtorClient
import org.example.day16.model.movie.MovieResponse

class KtorMovieDataSourceImpl() : MovieDataSource, KtorClient {
    override val baseUrl: String =
        "https://api.themoviedb.org/3/movie/upcoming?api_key=a64533e7ece6c72731da47c9c8bc691f"

    override suspend fun getMovieResponse(page: Int?, language: String?): MovieResponse = withContext(Dispatchers.IO) {
        try {
            val response = client.get("$baseUrl&page=$page&language=$language")
            defaultJson.decodeFromString<MovieResponse>(response.bodyAsText())
        } catch (e: Exception) {
            throw e
        }
    }
}