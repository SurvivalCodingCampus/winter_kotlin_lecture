package day19.model

data class Comment(
    val userId: Int,
    val content: String,
    val likes: List<User>,
    val dislike: List<User>,
)