package day16.data

import day16.model.Movie

class MovieRepositoryImpl(private val source: MovieDataSource) : MovieRepository {
    override suspend fun getMovieInfoList(): List<Movie> = source.getUpcomingMovies()
}