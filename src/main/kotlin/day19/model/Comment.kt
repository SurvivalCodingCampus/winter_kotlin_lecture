package day19.model

import java.time.LocalDateTime

data class Comment(
    val userId: Int,
    val content: String,
    val likes: Set<User>,
    val dislike: Set<User>,
    val editedAt: LocalDateTime,
    val createdAt: LocalDateTime,
)