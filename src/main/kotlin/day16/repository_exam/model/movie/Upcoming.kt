package org.example.day16.repository_exam.model.movie

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Upcoming(
    val dates: Dates,
    val page: Int,
    val results: List<MovieAllKey>,
    @SerialName("total_pages") val totalPages: Int,
    @SerialName("total_results") val totalResults: Int,
)