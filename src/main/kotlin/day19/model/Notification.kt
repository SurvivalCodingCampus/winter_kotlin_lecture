package org.hyunjung.day19.model

data class Notification(
    val id: Int,
    val title: String,
    val message: String,
    val type: NotificationType,
    val date: String,
    val isRead: Boolean
)

// 알람 타입 구분
enum class NotificationType(val id: Int) {
    RECIPE(1), Follow(2), LIKE(3)
}