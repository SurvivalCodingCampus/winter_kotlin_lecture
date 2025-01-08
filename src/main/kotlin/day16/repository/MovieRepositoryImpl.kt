package org.example.day16.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import org.example.day16.data_source.MovieDataSource
import org.example.day16.model.Movie

class MovieRepositoryImpl(override val movieDataSource: MovieDataSource) : MovieRepository {
    override suspend fun getMovieResponse(
        page: Int?,
        language: String?
    ): List<Movie> = withContext(Dispatchers.IO) {
        try {
            movieDataSource.getMovieResponse(page, language).results
        } catch (e: Exception) {
            when (e) {
                is SerializationException -> throw e
                else -> emptyList()
            }
        }
    }
}