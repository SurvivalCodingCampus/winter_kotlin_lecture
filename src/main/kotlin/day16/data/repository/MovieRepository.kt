package org.example.day16.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day16.data.model.Movie

interface MovieRepository {
    suspend fun getMovieInfoList(): Flow<List<Movie>>
}