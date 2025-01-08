package day16.exercise.repository.mock

import day16.exercise.model.Movie

interface MockMovieRepository {
    suspend fun getMovieData() : Movie?
}