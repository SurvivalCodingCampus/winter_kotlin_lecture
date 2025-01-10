package day17.mapper

import day17.dto.PhotoDto
import day17.model.Photo
import day17.model.PhotoType
import java.time.LocalDate


class PhotoMapper() {

    fun photoDTOtoPhoto(photoDto: PhotoDto): Photo {
        var type: PhotoType = PhotoType.UNKNOWN

        when(photoDto.type) {
            "Article" -> type = PhotoType.ARTICLE
            "Image" -> type = PhotoType.IMAGE
            "Video" -> type = PhotoType.VIDEO
            else -> type = PhotoType.UNKNOWN
        }

        var createdDate = LocalDate.parse(photoDto.createdAt)

        return Photo(
            photoDto.id,
            type,
            photoDto.title,
            photoDto.content,
            photoDto.url,
            photoDto.caption,
            createdDate
        )

    }
}