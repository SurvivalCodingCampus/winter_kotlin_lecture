package day19.repository

import day19.model.Notification
import day19.model.User

interface NotificationRepository {
    fun findByUser(user: User): List<Notification>
    fun markAsRead(notification: Notification): Boolean
    fun getSortedBySentDate(user: User): List<Notification>
}