package day16.exercise.datasource.movie

import utils.network.ResponseResult
import day16.exercise.model.Movie

interface MovieDataSource {

    suspend fun getUpcomingMovies(): ResponseResult<List<Movie>>
}