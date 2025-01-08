package org.hyunjung.day16.movie.repository

import org.hyunjung.day16.movie.datasource.MovieDataSource
import org.hyunjung.day16.movie.model.Movie

class MovieRepositoryImpl(
    private val dataSource: MovieDataSource
) : MovieRepository {
    override suspend fun getMovieInfoList(): List<Movie> {
        return dataSource.getUpcomingMovies()
    }
}