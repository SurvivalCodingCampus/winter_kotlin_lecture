@file:OptIn(ExperimentalSerializationApi::class)

package day16.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

@Serializable
@JsonIgnoreUnknownKeys
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("release_date") val releaseDate: LocalDate,
)

@Serializable
@JsonIgnoreUnknownKeys
internal data class RawMovie(
    val results: List<Movie>,
)