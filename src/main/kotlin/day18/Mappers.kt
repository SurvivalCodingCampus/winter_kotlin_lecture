package day18

import day18.dto.PhotoDto
import day18.model.Photo

fun PhotoDto.toPhoto(): Photo {
    return Photo(
        tags = this.tags?.split(",")?.map { it.trimStart() } ?: emptyList(),
        imageUrl = this.largeImageURL ?: "",
    )
}