package org.hyunjung.day18.mapper

import day18.dto.PhotoDto
import org.hyunjung.day18.model.Photo

object PhotoMapper {
    fun map(dto: PhotoDto): Photo? {
        val tags = dto.tags?.split(", ") ?: return null
        val imageUrl = dto.webformatURL ?: return null

        return Photo(
            tags = tags,
            imageUrl = imageUrl
        )
    }
}
