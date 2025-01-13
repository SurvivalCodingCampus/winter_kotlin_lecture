package day19.repository

import day19.model.Notification
import day19.model.User

interface NotificationRepository {
    // 알림 생성
    suspend fun createNotification(user: User, notification: Notification): Boolean

    // 알림 타입별 조회
    suspend fun findByType(user: User, notification: Notification): List<Notification>

    // 알림 읽음 표시
    suspend fun setUnreadNotification(notification: Notification): Notification
}
