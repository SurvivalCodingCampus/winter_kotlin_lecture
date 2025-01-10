package org.example.day17.repository.movie

import org.example.day17.data_source.movie.MovieDataSource
import org.example.day17.mapper.movie.toMovie
import org.example.day17.model.movie.Movie

class MovieRepositoryImpl(
    private val movieDataSource: MovieDataSource,
) : MovieRepository {

    override suspend fun getMovieInfoList(): List<Movie> {
        return movieDataSource.getUpcomingMovies()
            .map { it.toMovie() }
            .filter { it.id != -1 }
    }
}