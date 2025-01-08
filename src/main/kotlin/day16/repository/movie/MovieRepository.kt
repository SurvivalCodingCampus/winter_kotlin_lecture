package org.example.day16.repository.movie

import org.example.day16.data_source.movie.MovieDataSource
import org.example.day16.model.movie.Movie

interface MovieRepository {
    val movieDataSource: MovieDataSource
    suspend fun getMovieResponse(page: Int? = 1, language: String? = "ko-KR"): List<Movie>
}