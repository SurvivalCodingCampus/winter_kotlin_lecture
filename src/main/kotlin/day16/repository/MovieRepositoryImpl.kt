package day16.repository

import day16.dataSource.MovieDataSource
import day16.model.Movie

class MovieRepositoryImpl(private val dataSource: MovieDataSource): MovieRepository {
    override suspend fun getMovieInfoList(): List<Movie> {
        return dataSource.getUpcomingMovies()
    }
}