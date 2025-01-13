package day19.model

data class Post<T>(
    val id: Int,
    val owner: User,
    val title: String,
    val comments: List<Comment>,
    val media: List<Media>,
    val content: T,
)
