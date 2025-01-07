package org.example.day14

import kotlinx.serialization.Serializable

@Serializable
data class Geo(
    val lat: String,
    val lng: String,
)