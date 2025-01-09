package org.example.day16.repository_exam.data_source.movie

import kotlinx.serialization.json.Json
import org.example.day16.repository_exam.model.movie.Movie
import java.time.LocalDate

class MockMovieDataSourceImpl : MovieDataSource {
    private val json = """{
    "id": 939243,
    "title": "수퍼 소닉 3",
    "overview": "너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...",
    "release_date": "2024-12-19"
}
"""

    override suspend fun getAllMovieInfo(): List<Movie> {
        return Json.decodeFromString<List<Movie>>(listOf(json).toString())
    }

    override suspend fun getUpcomingMovies(): List<Movie> {
        return Json.decodeFromString<List<Movie>>(listOf(json).toString() ).filter { it.releaseDate > LocalDate.now().toString() }
    }

}