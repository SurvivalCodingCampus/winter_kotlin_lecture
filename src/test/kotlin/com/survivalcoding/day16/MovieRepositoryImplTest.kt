package com.survivalcoding.day16

import com.survivalcoding.com.survivalcoding.day16.Movie
import com.survivalcoding.com.survivalcoding.day16.MovieDataSource
import com.survivalcoding.com.survivalcoding.day16.MovieRepositoryImpl
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieRepositoryImplTest {
    private val mockMovieDataSource = object : MovieDataSource {
        override suspend fun getUpcomingMovies(): List<Movie> {
            val json = """[{
    "id": 939243,
    "title": "수퍼 소닉 3",
    "overview": "너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...",
    "release_date": "2024-12-19"
}]
"""
            return Json.decodeFromString<List<Movie>>(json)
        }

    }

    @Test
    fun getMovieInfoList() = runTest {
        val repository = MovieRepositoryImpl(mockMovieDataSource)
        val movies = repository.getMovieInfoList()

        val expected = Json.decodeFromString<Movie>(
            """{
    "id": 939243,
    "title": "수퍼 소닉 3",
    "overview": "너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...",
    "release_date": "2024-12-19"
}
"""
        )

        assertEquals(expected, movies[0])
    }
}