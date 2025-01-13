package day19.model

import io.ktor.http.*
import java.time.LocalDateTime
import java.util.*

data class Post<T>(
    val id: UUID,
    val owner: User,
    val title: String,
    val comments: List<Comment>,
    val shareableLink: Url,
    val editedAt: LocalDateTime,
    val createdAt: LocalDateTime,
    val media: List<Media>,
    val content: T,
)