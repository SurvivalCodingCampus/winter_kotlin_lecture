import java.time.LocalDate

enum class PhotoType {
    ARTICLE,
    IMAGE,
    VIDEO,
    UNKNOWN
}

fun handlePhotoType(photoType: String?): PhotoType =
    when (photoType) {
        "article" -> PhotoType.ARTICLE
        "image" -> PhotoType.IMAGE
        "video" -> PhotoType.VIDEO
        "unknown" -> PhotoType.UNKNOWN
        else -> {
            PhotoType.UNKNOWN
        }
    }


data class Photo(
    val id: String?,
    val type: PhotoType?,
    val title: String?,
    val content: String?,
    var createdAt: LocalDate?

)


