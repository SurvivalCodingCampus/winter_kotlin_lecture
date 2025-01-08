package day16.exercise.datasource.mock

import day15.common.ResponseResult
import day16.exercise.model.Movie

interface MockMovieDataSource {
    suspend fun getMovieData(): ResponseResult<Movie>
}