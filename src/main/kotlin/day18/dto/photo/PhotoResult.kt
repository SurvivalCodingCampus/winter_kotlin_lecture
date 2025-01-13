package org.example.day18.dto.photo

import kotlinx.serialization.Serializable

@Serializable
data class PhotoResult(
    val total: Int?,
    val totalHits: Int?,
    val hits: List<PhotoDto>?,
)