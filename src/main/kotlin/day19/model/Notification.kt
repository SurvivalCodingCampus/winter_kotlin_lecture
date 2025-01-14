package day19.model

import java.time.LocalDateTime

data class Notification(
    val title: String,
    val contents: String,
    val sentAt: LocalDateTime,
    val recipient: User,
    val isRead: Boolean,
    val linkedPost: Post<*>,
)
