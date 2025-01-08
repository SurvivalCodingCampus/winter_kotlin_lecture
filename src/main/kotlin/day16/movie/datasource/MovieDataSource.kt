package org.hyunjung.day16.movie.datasource

import org.hyunjung.day16.movie.model.Movie

interface MovieDataSource {
    suspend fun getUpcomingMovies(): List<Movie>
}