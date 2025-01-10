package day17.mapper

import day17.dto.PhotoDto
import day17.model.Photo as DomainPhoto
import day17.model.PhotoType
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
fun photoMapper(dto: PhotoDto): DomainPhoto {
    val type = when (dto.type?.lowercase(Locale.getDefault())) {
        "article" -> PhotoType.Article
        "image" -> PhotoType.Image
        "video" -> PhotoType.Video
        else -> PhotoType.Unknown
    }

    val createdAt = dto.createdAt?.let {// null이 아니면 let 블록이 실행
        try {
            LocalDate.parse(it, dateFormatter)
        } catch (e: Exception) {
            println("날짜 파싱 실패: $it, 오류: ${e.message}")
            null
        }
    }

    return DomainPhoto(
        id = dto.id ?: "",
        createdAt = createdAt ?: LocalDate.now(),
        type = type,
        title = dto.title ?: "",
        content = dto.content ?: "",
        url = dto.url ?: "",
        caption = dto.caption ?: ""
    )
}

