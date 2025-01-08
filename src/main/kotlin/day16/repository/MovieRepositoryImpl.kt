package day16.repository

import day16.data_source.MovieDataSource
import day16.model.Movie

class MovieRepositoryImpl(private val dataSource: MovieDataSource): MovieRepository {
    override suspend fun getMovieInfoList(): List<Movie> {
        return try {
            dataSource.getUpcomingMovies()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
