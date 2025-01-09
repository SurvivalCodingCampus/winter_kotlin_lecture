package org.example.day17.data_source.movie

import org.example.day17.dto.MovieDto

interface MovieDataSource {
    suspend fun getUpcomingMovies(): List<MovieDto>
}