package org.example.day17.data_source.movie

import org.example.day17.dto.movie.MovieDto

interface MovieDataSource {
    suspend fun getUpcomingMovies(): List<MovieDto>
}