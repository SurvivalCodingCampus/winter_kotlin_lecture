package day16.dataSource

import day16.model.Movie

interface MovieDataSource {
    suspend fun getUpcomingMovies() : List<Movie>
}