package org.example.day16.repository

import org.example.day16.data_source.MovieDataSource
import org.example.day16.model.Movie

interface MovieRepository {
    val movieDataSource: MovieDataSource
    suspend fun getMovieResponse(page: Int? = 1, language: String? = "ko-KR"): List<Movie>
}