package day18.mapper

import day18.dto.PhotoDto
import day18.model.Photo

fun PhotoDto.toPhoto() = Photo(
    tags = tags?.split(",") ?: emptyList(),
    imageUrl = pageURL ?: ""
)