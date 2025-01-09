package day16.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val results: List<Movie>
)