package day16.repository
import day16.model.Movie

interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}