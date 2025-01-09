package org.example.day16.data.datasource

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.util.jsonConfig
import org.example.day16.data.model.Movie
import org.example.day16.data.model.UpcomingMovie
import org.example.day16.data.resource.movieUrlPath

class MovieDataSourceImpl(
    private val httpClient: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(jsonConfig)
        }
    }
) : MovieDataSource {
    override suspend fun getUpcomingMovies(): Flow<List<Movie>> = flow {
        httpClient.use { client ->
            val movies = client.get(movieUrlPath) {
                url {
                    parameters.append("language", "ko-KR")
                    parameters.append("page", "1")
                }
            }.body<UpcomingMovie>().results
            emit(movies)
        }
    }
}