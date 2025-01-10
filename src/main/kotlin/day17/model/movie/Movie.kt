package org.example.day17.model.movie

import kotlinx.serialization.SerialName
import java.time.LocalDate

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("release_date") val releaseDate: LocalDate,
)