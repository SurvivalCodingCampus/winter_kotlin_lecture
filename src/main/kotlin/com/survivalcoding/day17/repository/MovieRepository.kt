package com.survivalcoding.day17.repository

import com.survivalcoding.day17.model.Movie

interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}
