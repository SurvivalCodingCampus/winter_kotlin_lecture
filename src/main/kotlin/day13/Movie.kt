package org.example.day13

import kotlinx.serialization.Serializable

@Serializable
class Movie(
    val title: String,
    val director: String,
    val year: Int,
)