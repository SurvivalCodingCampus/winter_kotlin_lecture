package org.example.day16.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day16.data.datasource.MovieDataSource
import org.example.day16.data.model.Movie

class MovieRepositoryImpl(
    private val movieDataSource: MovieDataSource
) : MovieRepository {
    override suspend fun getMovieInfoList(): Flow<List<Movie>> =
        movieDataSource.getUpcomingMovies()
}