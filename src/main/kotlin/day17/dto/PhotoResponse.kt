package org.example.day17.dto

import kotlinx.serialization.Serializable
import org.example.day17.model.Photo
import org.example.day17.model.Type
import java.time.LocalDate

@Serializable
data class PhotoResponse(
    val id: Int?,
    val type: String? = null,
    val title: String? = null,
    val url: String? = null,
    val caption: String? = null,
    val content: String? = null,
    val created_at: String?,
)

fun PhotoResponse.asExternalModel() = Photo(
    id = id ?: Int.MIN_VALUE,
    type = when (type) {
        "article" -> Type.ARTICLE
        "image" -> Type.IMAGE
        "video" -> Type.VIDEO
        else -> Type.UNKNOWN
    },
    title = title.defaultIfNullOrBlank(),
    url = url.defaultIfNullOrBlank(),
    caption = caption.defaultIfNullOrBlank(),
    content = content.defaultIfNullOrBlank(),
    createdAt = created_at?.let {
        LocalDate.parse(it)
    } ?: LocalDate.MIN
)

private fun String?.defaultIfNullOrBlank(): String {
    return if (this.isNullOrBlank()) "" else this
}
