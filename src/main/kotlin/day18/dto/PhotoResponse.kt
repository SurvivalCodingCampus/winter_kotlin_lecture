package day18.dto

import kotlinx.serialization.Serializable

@Serializable
data class PhotoResponse(
    val hits: List<PhotoDto>,
    val total: Int,
    val totalHits: Int
)