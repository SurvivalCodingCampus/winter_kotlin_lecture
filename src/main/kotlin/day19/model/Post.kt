package day19.model

import io.ktor.http.*
import java.util.*

data class Post<T>(
    val id: UUID,
    val owner: User,
    val title: String,
    val comments: List<Comment>,
    val shareableLink: Url,
    val media: List<Media>,
    val content: T,
)