package day16.data

import day16.model.Movie
import day16.model.RawMovie
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDataSourceImpl : MovieDataSource {
    private val tmdbAPI =
        "https://api.themoviedb.org/3/movie/upcoming?api_key=a64533e7ece6c72731da47c9c8bc691f&language=ko-KR&page=1"

    override suspend fun getUpcomingMovies(): List<Movie> = withContext(Dispatchers.IO) {
        val response = Data.client.get(tmdbAPI).body<RawMovie>()
        response.results
    }
}