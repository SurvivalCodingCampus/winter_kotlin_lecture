package org.example.day16.repository_exam.model.movie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Upcoming(
    val results: List<Movie>,
)