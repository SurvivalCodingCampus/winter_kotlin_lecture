package day17.repository

import day17.model.Movie

interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}