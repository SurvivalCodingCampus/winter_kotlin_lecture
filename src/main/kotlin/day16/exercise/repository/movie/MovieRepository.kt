package day16.exercise.repository.movie

import day16.exercise.model.Movie

interface MovieRepository {

    suspend fun getMovieInfoList(): List<Movie>
}