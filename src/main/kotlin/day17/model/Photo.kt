package day17.model

import java.time.LocalDate

data class Photo(
    val id: Int? = null,
    val type: PhotoType,
    val title: String? = null,
    val content: String? = null,
    val url: String? = null,
    val caption: String? = null,
    val createdAt: LocalDate,
)

enum class PhotoType {
    ARTICLE,
    IMAGE,
    VIDEO,
    UNKNOWN
}