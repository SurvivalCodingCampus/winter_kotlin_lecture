package day16.exercise.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/*
* <요구사항>
* 실제 TMDB API를 호출하는 MovieDataSourceImpl 구현
* 테스트용 MockMovieDataSource 구현
* MovieRepositoryImpl 구현
* */

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("release_date")
    val releaseDate: String,
)

// 응답을 포장하는 모델
@Serializable
data class UpcomingMoviesResponse(
    val results: List<Movie>,  // 영화 목록
)



