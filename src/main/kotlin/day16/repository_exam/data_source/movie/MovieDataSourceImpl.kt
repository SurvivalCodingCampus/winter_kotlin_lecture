package org.example.day16.repository_exam.data_source.movie

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import org.example.day16.repository_exam.model.movie.Movie
import org.example.day16.repository_exam.model.movie.Upcoming
import java.time.LocalDate

class MovieDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO),
) : MovieDataSource {
    private val url =
        "https://api.themoviedb.org/3/movie/upcoming?api_key=a64533e7ece6c72731da47c9c8bc691f&language=ko-KR&page=1"

    override suspend fun getAllMovieInfo(): List<Movie> {
        val movieList: MutableList<Movie> = mutableListOf()
        Json.decodeFromString<Upcoming>(client.get(url).bodyAsText()).results.forEach {
            movieList.add(
                Movie(
                    it.id,
                    it.title,
                    it.overview,
                    it.releaseDate
                )
            )
        }
        return movieList
    }

    override suspend fun getUpcomingMovies(): List<Movie> {
        val movieList: MutableList<Movie> = mutableListOf()
        Json.decodeFromString<Upcoming>(client.get(url).bodyAsText()).results.forEach {
            movieList.add(
                Movie(
                    it.id,
                    it.title,
                    it.overview,
                    it.releaseDate
                )
            )
        }
        return movieList.filter { it.releaseDate > LocalDate.now().toString() }
    }
}