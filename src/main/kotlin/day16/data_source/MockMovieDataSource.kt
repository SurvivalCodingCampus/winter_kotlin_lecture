package day16.data_source

import day16.model.Movie
import kotlinx.serialization.json.Json

class MockMovieDataSource(private val shouldThrowException: Boolean = false) : MovieDataSource {
    override suspend fun getUpcomingMovies(): List<Movie> {
        if (shouldThrowException) {
            throw Exception("Network Error")
        }

        return Json.decodeFromString(testData)
    }

    private val testData = """
    [{
        "id": 939243,
        "title": "수퍼 소닉 3",
        "overview": "너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...",
        "release_date": "2024-12-19"
    }]
"""
}
