package day16.exercise.datasource.movie

import day15.common.ResponseResult
import day15.common.safeCall
import day16.exercise.model.Movie
import day16.exercise.model.UpcomingMoviesResponse
import day16.util.HttpClientFactory
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDataSourceImpl : MovieDataSource {
    override suspend fun getUpcomingMovies(): ResponseResult<List<Movie>> = withContext(Dispatchers.IO) {
        safeCall {
            val response = HttpClientFactory.client.get("https://api.themoviedb.org/3/movie/upcoming") {
                url {
                    parameters.append("api_key", "a64533e7ece6c72731da47c9c8bc691f")
                    parameters.append("language", "ko-KR")
                    parameters.append("page", "1")
                }
            }

            // 응답을 직렬화 하여 변환
            val upcomingMoviesResponse = response.body<UpcomingMoviesResponse>()

            // results 반환
            upcomingMoviesResponse.results

        }
    }
}