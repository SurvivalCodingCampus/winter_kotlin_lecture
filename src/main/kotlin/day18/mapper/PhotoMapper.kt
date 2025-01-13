package day18.mapper

import PhotoDto
import day18.model.Photo

fun PhotoDto.toPhoto(): Photo {     // 확장함수
    return Photo(
        tags = tags?.split(",") ?: emptyList(),
        imageUrl = largeImageURL ?: ""
    )
}