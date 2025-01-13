package org.hyunjung.day17.maskstore.model

import kotlinx.serialization.Serializable

@Serializable
data class Store(
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val stockStatus: String,
    val stockUpdatedAt: String
)