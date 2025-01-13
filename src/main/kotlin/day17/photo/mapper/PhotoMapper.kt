package org.hyunjung.day17.photo.mapper

import org.hyunjung.day17.photo.dto.PhotoDto
import org.hyunjung.day17.photo.model.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object PhotoMapper {
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    fun map(dto: PhotoDto): Photo? {
        val id = dto.id
        val createdAt = dto.createdAt?.let { parseDate(it) } ?: return null

        return when (getType(dto.type)) {
            PhotoType.Article -> {
                if (dto.title != null && dto.content != null) {
                    Article(id = id, createdAt = createdAt, title = dto.title, content = dto.content)
                } else null
            }
            PhotoType.Image -> {
                if (dto.url != null && dto.caption != null) {
                    Image(id = id, createdAt = createdAt, url = dto.url, caption = dto.caption)
                } else null
            }
            PhotoType.Video -> {
                if (dto.url != null && dto.caption != null) {
                    Video(id = id, createdAt = createdAt, url = dto.url, caption = dto.caption)
                } else null
            }
            PhotoType.Unknown -> null
        }
    }

    private fun getType(type: String?): PhotoType {
        return when (type) {
            "article" -> PhotoType.Article
            "image" -> PhotoType.Image
            "video" -> PhotoType.Video
            else -> PhotoType.Unknown
        }
    }

    private fun parseDate(date: String): LocalDate {
        return LocalDate.parse(date, dateFormatter)
    }
}