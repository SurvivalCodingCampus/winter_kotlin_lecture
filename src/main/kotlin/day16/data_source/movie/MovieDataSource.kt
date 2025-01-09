package org.example.day16.data_source.movie

import org.example.day15.data_source.DataSource
import org.example.day16.model.movie.MovieResponse

interface MovieDataSource : DataSource {
    suspend fun getMovieResponse(page: Int? = 1, language: String? = "ko-KR"): MovieResponse
}