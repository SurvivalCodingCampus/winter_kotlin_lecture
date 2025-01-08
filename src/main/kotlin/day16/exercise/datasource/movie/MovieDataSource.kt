package day16.exercise.datasource.movie

import day15.common.ResponseResult
import day16.exercise.model.Movie

interface MovieDataSource {

    suspend fun getUpcomingMovies(): ResponseResult<List<Movie>>
}