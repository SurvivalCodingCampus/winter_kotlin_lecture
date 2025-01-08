package day16.data

import day16.model.Movie
import kotlinx.serialization.json.Json

class MockMovieDataSource() : MovieDataSource {
    override suspend fun getUpcomingMovies(): List<Movie> = Json.decodeFromString(Data.upcomingMovieJson)
}