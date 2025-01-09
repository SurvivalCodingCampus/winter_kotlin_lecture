package day17.model

enum class MediaType {
    ARTICLE,
    IMAGE,
    VIDEO,
    UNKNOWN;

    companion object {
        fun of(key: String?) = when (key?.lowercase()) {
            "article" -> ARTICLE
            "image" -> IMAGE
            "video" -> VIDEO
            else -> UNKNOWN
        }
    }
}