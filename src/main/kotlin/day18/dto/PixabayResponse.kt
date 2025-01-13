package org.example.day18.dto

import kotlinx.serialization.Serializable

@Serializable
data class PixabayResponse(
    val total: Int,
    val totalHits: Int,
    val hits: List<PhotoResponse>,
)