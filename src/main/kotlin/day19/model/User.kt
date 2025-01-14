package day19.model

import java.time.LocalDateTime
import java.util.*

data class User(
    val id: UUID,
    val memberSince: LocalDateTime,
    val nickname: String,
    val fullName: String,
    val email: Email,
    val profileImage: Media,
    val following: Set<User>,
    val followers: Set<User>,
    val bio: String,
    val occupation: String,
    val address: String,
    val savedRecipes: Set<Post<Recipe>>,
)

@JvmInline
value class Email(val address: String)