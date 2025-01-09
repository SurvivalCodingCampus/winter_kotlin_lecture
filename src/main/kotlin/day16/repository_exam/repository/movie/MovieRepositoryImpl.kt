package org.example.day16.repository_exam.repository.movie

import org.example.day16.repository_exam.data_source.movie.MovieDataSource
import org.example.day16.repository_exam.model.movie.Movie

class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository {
    override suspend fun getMovieInfoList(): List<Movie> {
        return dataSource.getAllMovieInfo()
    }
}