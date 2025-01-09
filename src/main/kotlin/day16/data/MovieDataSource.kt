package day16.data

import day16.model.Movie

interface MovieDataSource {
    suspend fun getUpcomingMovies(): List<Movie>
}