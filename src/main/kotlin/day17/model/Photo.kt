package day17.model

import java.time.LocalDate

enum class PhotoType {      // enum 클래스 내에서 각각의 값은 고유한 상수
    Article,
    Image,
    Video,
    Unknown
}

data class Photo(
    val id: String,
    val createdAt: LocalDate,
    val type: PhotoType,
    val title: String,
    val content: String,
    val url: String,
    val caption: String
)
