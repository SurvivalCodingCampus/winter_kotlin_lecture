package day17.mapper

import day17.dto.PhotoDto
import day17.model.Photo
import day17.model.PhotoType
import java.time.LocalDate


class PhotoMapper() {

    fun PhotoDtotoPhoto(photoDto: PhotoDto): Photo {
        var type: PhotoType = PhotoType.Unknown

        when(photoDto.type) {
            "Article" -> type = PhotoType.Article
            "Image" -> type = PhotoType.Image
            "Video" -> type = PhotoType.Video
            else -> type = PhotoType.Unknown
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