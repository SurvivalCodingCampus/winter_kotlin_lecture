package org.example.day17.repository.movie

import org.example.day17.model.movie.Movie
import org.example.day17.util.movie.Result

interface MovieRepository {
    suspend fun getMovieInfoList(): Result<List<Movie>>
}