package org.example.day16.data_source

import org.example.day15.data_source.DataSource
import org.example.day16.model.MovieResponse

interface MovieDataSource : DataSource {
    suspend fun getMovieResponse(page: Int? = 1, language: String? = "ko-KR"): MovieResponse
}