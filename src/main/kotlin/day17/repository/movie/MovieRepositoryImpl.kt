package org.example.day17.repository.movie

import org.example.day17.data_source.movie.MovieDataSource
import org.example.day17.mapper.movie.toMovie
import org.example.day17.model.movie.Movie
import org.example.day17.util.movie.Result

class MovieRepositoryImpl(
    private val movieDataSource: MovieDataSource,
) : MovieRepository {

    override suspend fun getMovieInfoList(): Result<List<Movie>> {
        return try {
            val movies = movieDataSource.getUpcomingMovies().map { it.toMovie() }.filter { it.id != -1 }

            if (movies.isEmpty()) {
                Result.Error(IllegalArgumentException("값이 없음"))
            }

            Result.Success(movies)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}