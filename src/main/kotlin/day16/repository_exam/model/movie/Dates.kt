package org.example.day16.repository_exam.model.movie

import kotlinx.serialization.Serializable

@Serializable
data class Dates(
    val maximum: String,
    val minimum: String,
)