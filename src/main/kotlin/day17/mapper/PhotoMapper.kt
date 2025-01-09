package day17.mapper

import day17.dto.PhotoDto
import day17.model.Photo
import day17.model.PhotoType
import day17.utils.convertToDate

fun PhotoDto.mapper(): Photo {
    return Photo(
        id = id ?: 0,
        type = PhotoType.getType(type),
        createdAt = convertToDate(createdAt)
    )
}