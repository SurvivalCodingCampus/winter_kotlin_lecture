package org.example.day18.mapper

import day18.dto.PhotoDto
import org.example.day18.model.Photo

fun PhotoDto.toPhoto() = Photo(
    tags = tags.split(",").map { it.trim() }, // 쉼표로 구분된 문자열을 List로 변환
    imageUrl = largeImageURL
)
fun List<PhotoDto>.toPhotoList(): List<Photo> {
    return this.map { it.toPhoto() }
}