package day16.exercise.repository.movie

import utils.network.ResponseResult
import day16.exercise.datasource.movie.MovieDataSource
import day16.exercise.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(
    private val movieDataSource: MovieDataSource
) : MovieRepository {
    override suspend fun getMovieInfoList(): List<Movie> = withContext(Dispatchers.IO) {

        when (val result = movieDataSource.getUpcomingMovies()) {
            is ResponseResult.Success -> {
                result.data
            }

            is ResponseResult.Failure -> {
                println("통신 실패 ${result.exception.message}")
                emptyList()
            }
        }

    }

}