package day19.model

data class User(
    val id: Int,
    val auth: AuthData,
    val bookmarks: List<Bookmark>,
    val settings: Setting,
)