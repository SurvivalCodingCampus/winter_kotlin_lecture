package org.example.day17.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoDto(
    val id: Int?,
    val type: String?,
    val title: String? = null,
    val url: String? = null,
    val content: String? = null,
    val caption: String? = null,
    @SerialName("created_at")
    val createdAt: String?
)
