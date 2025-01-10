package org.example.day17.dto.photo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class PhotoDto(
    val id: Int?,
    val type: String? = null,
    val title: String? = null,
    val content: String? = null,
    val url: String? = null,
    val caption: String? = null,
    @SerialName("created_at") val createdAt: String?,
) {
    companion object {
        fun checkType(type: PhotoType) {

        }

        fun stringDataIsEmpty(data: String?): String {
            if (data == null) return ""
            return data
        }

        fun intDataIsEmpty(data: Int?): Int {
            if (data == null) return -1
            return data
        }


        fun getLocalDate(createdAt: String?): LocalDate {
            if (createdAt == null) return LocalDate.of(0, 0, 0)

            val timeList: List<String> = createdAt.split("-")

            return LocalDate.of(timeList[0].toInt(), timeList[1].toInt(), timeList[2].toInt())
        }
    }

}

enum class PhotoType(val type: String) {
    ARTICLE("article"),
    IMAGE("image"),
    VIDEO("video"),
    UNKNOWN("unknown");

    companion object {
        fun checkPhotoType(typeNum: String?): PhotoType {
            return entries.find { it.type == typeNum } ?: UNKNOWN
        }
    }
}