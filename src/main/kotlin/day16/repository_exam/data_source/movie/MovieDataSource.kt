package org.example.day16.repository_exam.data_source.movie

import org.example.day16.repository_exam.model.movie.Movie

interface MovieDataSource {
    suspend fun getAllMovieInfo(): List<Movie>
    suspend fun getUpcomingMovies(): List<Movie>
}