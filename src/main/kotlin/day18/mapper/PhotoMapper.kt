package day18.mapper

import day18.dto.PhotoDto
import day18.model.Photo

fun PhotoDto.toPhoto(): Photo {
    val imageUrl: String = this.webformatURL ?: ""
    val checkForTags = this.tags?.split(",")?.map {
        it.trim()
    }

    return Photo(checkForTags ?: emptyList<String>(), imageUrl)
}