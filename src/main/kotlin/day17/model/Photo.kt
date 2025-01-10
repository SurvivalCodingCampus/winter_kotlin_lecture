package org.example.day17.model

import java.time.LocalDate

data class Photo(
    val id: Int,
    val type: PhotoType,
    val title: String? = null,
    val url: String? = null,
    val caption: String? = null,
    val content: String? = null,
    val createdAt: LocalDate,
)


enum class PhotoType {
    ARTICLE, IMAGE, VIDEO, UNKNOWN
}
