package com.survivalcoding.day17.data_source

import com.survivalcoding.com.survivalcoding.day17.dto.MovieDto

interface MovieDataSource {
    suspend fun getUpcomingMovies(): List<MovieDto>
}