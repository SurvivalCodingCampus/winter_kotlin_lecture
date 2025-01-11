package org.example.day18.mapper.photo

import org.example.day18.dto.photo.PhotoDto
import org.example.day18.model.photo.Photo

fun PhotoDto.toPhoto() = Photo(
    tags = splitTags(tags),
    imageUrl = webformatUrl ?: "",
)

private fun splitTags(tags: String?): List<String> {
    if (tags != null) return tags.split(", ")
    return listOf("")
}