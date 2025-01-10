package day18.mapper

import day18.dto.PhotoDto
import day18.model.Photo

fun PhotoDto.mapper(): Photo {
    return Photo(
        tags = tags?.split(",")?.map { it } ?: emptyList(),
        imageUrl = largeImageURL ?: ""
    )
}