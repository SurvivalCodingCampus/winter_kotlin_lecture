package org.example.day16.data.datasource

import kotlinx.coroutines.flow.Flow
import org.example.day16.data.model.Movie

interface MovieDataSource {
    suspend fun getUpcomingMovies(): Flow<List<Movie>>
}