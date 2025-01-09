package day17.data_source

import day17.dto.MovieDto

interface MovieDataSource {
    suspend fun getUpcomingMovies(): List<MovieDto>
}