package org.example.day16.repository_exam.repository.movie

import org.example.day16.repository_exam.model.movie.Movie

interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}