package day17

import PhotoType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PhotoDto(
    val id: String? = null,
    val type: String? = null,
    val title: String? = null,
    val content: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,


    )



