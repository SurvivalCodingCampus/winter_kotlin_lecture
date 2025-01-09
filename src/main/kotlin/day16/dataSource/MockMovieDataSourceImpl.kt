package day16.dataSource

import day16.model.Movie

class MockMovieDataSourceImpl : MovieDataSource {
    override suspend fun getUpcomingMovies(): List<Movie> {
        return listOf(
            Movie(
                id = 939243,
                title = "수퍼 소닉 3",
                overview = "너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...",
                releaseDate = "2024-12-19"
            )
        )
    }
}
