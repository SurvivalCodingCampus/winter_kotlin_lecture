package day17.mapper

import day17.dto.PhotoDto
import day17.model.Photo
import day17.model.PhotoType
import java.time.LocalDate

fun PhotoDto.toPhoto() = Photo(
    id = id ?: -1,
    type = when (type?.lowercase()) {
        "article" -> PhotoType.Article
        "image" -> PhotoType.Image
        "video" -> PhotoType.Video
        else -> PhotoType.Unknown
    },
    title = title ?: "",
    content = content ?: "",
    createdAt = created_at?.let { LocalDate.parse(it) } ?: LocalDate.parse("0000-00-00")
)