package day16.exercise.datasource.mock

import utils.network.ResponseResult
import day16.exercise.model.Movie

interface MockMovieDataSource {
    suspend fun getMovieData(): ResponseResult<Movie>
}