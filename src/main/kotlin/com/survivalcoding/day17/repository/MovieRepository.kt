package com.survivalcoding.day17.repository

import com.survivalcoding.day17.model.Movie
import com.survivalcoding.day17.util.Result

interface MovieRepository {
    suspend fun getMovieInfoList(): Result<List<Movie>>
}
