package day17.model

import java.time.LocalDate

// Model 클래스
data class Photo(
    val id: Int,
    val type: PhotoType,
    val createdAt: LocalDate
)

enum class PhotoType(val type: String) {
    ARTICLE("Article"),
    IMAGE("Image"),
    VIDEO("Video"),
    UNKNOWN("Unknown");

    companion object {
        // String 값을 Enum에 맞게 변환 -> 대소문자 구분하지 않음(ignorecase)
        fun getType(value: String?): PhotoType {
            return entries.find { it.type.equals(value, ignoreCase = true) } ?: UNKNOWN
        }
    }
}