package day19.model

data class Notification<T>(
    val title: String,
    val contents: String,
    val isRead: Boolean,
    val linkedPost: Post<T>,
)
