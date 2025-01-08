package day16.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("release_date")
    val releaseDate: String
)

@Serializable
data class Movies(
    val results: List<Movie> // results 배열만 파싱
)