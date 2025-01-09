package org.example.day17.model

import java.time.LocalDate

data class Content(
    val id: Int,
    val type: ContentType,
    val title: String,
    val content: String,
    val url: String,
    val caption: String,
    val createdAt: LocalDate,
)

enum class ContentType {
    ARTICLE,
    IMAGE,
    VIDEO,
    UNKNOWN;

    companion object {
        fun fromString(value: String?): ContentType {
            return when (value) {
                "article" -> ARTICLE
                "image" -> IMAGE
                "video" -> VIDEO
                else -> UNKNOWN
            }
        }
    }
}