package day17.dto

//무지성 Nullable 데이터클래스
//Shift+F6 같은항목 찾아 바꾸기
// 이름만 어미에 Dto로 바꾸고
//data class MovieDto()
import kotlinx.serialization.Serializable

@Serializable
data class MovieResult(
    val dates: DatesDto?,
    val page: Int?,
    val results: List<MovieDto>?,
    val total_pages: Int?,
    val total_results: Int?
)

@Serializable
data class DatesDto(
    val maximum: String?,
    val minimum: String?
)

@Serializable
data class MovieDto(
    val adult: Boolean?,
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val id: Int?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
)