package org.example.day18.mapper

import day18.dto.PhotoDto
import day18.dto.PixabayResponseDto
import org.example.day18.model.Photo

fun PixabayResponseDto.toModel(): List<Photo> {
    if (this.hits.isNullOrEmpty()) return emptyList()
    return this.hits.map {
        it.toModel()
    }
}

fun PhotoDto.toModel(): Photo {
    return Photo(
        tags = this.tags?.split(",") ?: emptyList(),
        imageUrl = this.webformatURL ?: ""
    )
}