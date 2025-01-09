package org.hyunjung.day16.movie.datasource

import io.ktor.client.call.*
import io.ktor.client.request.*
import org.hyunjung.day16.ApiModule
import org.hyunjung.day16.movie.model.Movie
import org.hyunjung.day16.movie.model.MovieDb

class MovieDataSourceImpl : MovieDataSource {

    private val client = ApiModule.create()
    private val baseUrl = "https://api.themoviedb.org/3"

    override suspend fun getUpcomingMovies(): List<Movie> {
        val response = client.get("$baseUrl/movie/upcoming") {
            url {
                parameters.append("api_key", "a64533e7ece6c72731da47c9c8bc691f")
                parameters.append("language", "ko-KR")
                parameters.append("page", "1")
            }
        }
        val movieDb = response.body<MovieDb>()

        return movieDb.results.map { result ->
            Movie(
                id = result.id,
                title = result.title,
                overview = result.overview,
                releaseDate = result.releaseDate
            )
        }
    }
}