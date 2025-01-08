package org.example.day15.repository_exam.model.user

import kotlinx.serialization.Serializable

@Serializable
data class Geo(
    val lat: String,
    val lng: String,
)