package org.hyunjung.day16.movie.repository

import org.hyunjung.day16.movie.model.Movie

interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}