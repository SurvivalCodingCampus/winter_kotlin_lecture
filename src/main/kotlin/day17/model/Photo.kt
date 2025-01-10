package org.example.day17.model

import java.time.LocalDate

data class Photo(
    val id: Int,
    val type: Type,
    val title: String,
    val url: String,
    val caption: String,
    val content: String,
    val createdAt: LocalDate,
) {
    override fun toString(): String {
        return buildString {
            append("Photo(id=$id, type=$type")
            if (title.isNotEmpty()) append(", title=$title")
            if (url.isNotEmpty()) append(", url=$url")
            if (caption.isNotEmpty()) append(", caption=$caption")
            if (content.isNotEmpty()) append(", content=$content")
            append(", createdAt=$createdAt)")
        }
    }
}