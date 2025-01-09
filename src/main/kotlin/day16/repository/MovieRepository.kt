package org.example.day16.repository

import day16.model.Movie
import org.example.day16.datasource.MovieDataSource

interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}

class MovieRepositoryImpl(private val dataSource: MovieDataSource): MovieRepository {
    override suspend fun getMovieInfoList(): List<Movie> {
        return dataSource.getUpcomingMovies()
    }
}