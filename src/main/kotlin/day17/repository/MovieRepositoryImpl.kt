package day17.repository

import day17.data_source.MovieDataSource
import day17.mapper.toMovie
import day17.model.Movie

class MovieRepositoryImpl(
    private val movieDataSource: MovieDataSource,
) : MovieRepository {

    override suspend fun getMovieInfoList(): List<Movie> {
        return movieDataSource.getUpcomingMovies()
            .map { it.toMovie() }
            .filter { it.id != -1 }
    }
}