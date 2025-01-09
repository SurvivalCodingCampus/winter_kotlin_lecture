package com.survivalcoding.com.survivalcoding.day17.repository

import com.survivalcoding.com.survivalcoding.day17.mapper.toMovie
import com.survivalcoding.day17.data_source.MovieDataSource
import com.survivalcoding.day17.model.Movie
import com.survivalcoding.day17.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieDataSource: MovieDataSource,
) : MovieRepository {

    override suspend fun getMovieInfoList(): List<Movie> {
        return movieDataSource.getUpcomingMovies()
            .map { it.toMovie() }
            .filter { it.id != -1 }
    }
}