package day16.data_source

import day16.model.Movie

interface MovieDataSource {
    suspend fun getUpcomingMovies(): List<Movie>
}