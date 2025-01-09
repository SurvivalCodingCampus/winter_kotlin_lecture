package day16.data

import day16.model.Movie

interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}