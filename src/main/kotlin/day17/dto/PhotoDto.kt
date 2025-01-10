package day17.dto

import kotlinx.serialization.Serializable

@Serializable
data class PhotoDto(
    val id: Int? = null,
    val type: String? = null,
    val title: String? = null,
    val content: String? = null,
    val url: String? = null,
    val caption: String? = null,
    val created_at: String? = null
)
