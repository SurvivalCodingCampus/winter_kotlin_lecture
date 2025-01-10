package com.survivalcoding.com.survivalcoding.day17.repository

import com.survivalcoding.com.survivalcoding.day17.mapper.toMovie
import com.survivalcoding.day17.data_source.MovieDataSource
import com.survivalcoding.day17.model.Movie
import com.survivalcoding.day17.repository.MovieRepository
import com.survivalcoding.day17.util.Result

class MovieRepositoryImpl(
    private val movieDataSource: MovieDataSource,
) : MovieRepository {

    override suspend fun getMovieInfoList(): Result<List<Movie>> {
        return try {
            val movies = movieDataSource.getUpcomingMovies()
                .map { it.toMovie() }
                .filter { it.id != -1 }

            if (movies.isEmpty()) {
                Result.Error(IllegalArgumentException("값이 없음"))
            }

            Result.Success(movies)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}