package org.example.day17.repository.movie

import org.example.day17.model.movie.Movie

interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}