package day19.model

import java.time.LocalDateTime

data class Comment(
    val userId: Int,
    val content: String,
    val likes: List<User>,
    val dislike: List<User>,
    val editedAt: LocalDateTime,
    val createdAt: LocalDateTime,
)