package org.example.day17.mapper.photo

import org.example.day17.dto.photo.PhotoDto
import org.example.day17.dto.photo.PhotoType
import org.example.day17.model.photo.Photo

fun PhotoDto.toPhoto() = Photo(
    id = PhotoDto.intDataIsEmpty(id),
    type = PhotoType.checkPhotoType(type).type,
    title = PhotoDto.stringDataIsEmpty(title),
    content = PhotoDto.stringDataIsEmpty(content),
    url = PhotoDto.stringDataIsEmpty(url),
    caption = PhotoDto.stringDataIsEmpty(caption),
    createdAt = PhotoDto.getLocalDate(createdAt)
)