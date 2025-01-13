package day16.dataSource

import day16.api.MovieApiImpl
import day16.model.Movie

class MovieDataSourceImpl(private val api: MovieApiImpl) : MovieDataSource {
    override suspend fun getUpcomingMovies(): List<Movie> {
        val movieResponse = api.fetchUpcomingMovies()   // TMDB API 호출 -> 영화 목록 데이터를 가져온다
        return movieResponse.results     // 응답에서 영화 목록을 반환
    }
}