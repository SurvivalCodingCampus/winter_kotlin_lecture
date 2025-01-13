package day19.model

import java.util.*

data class User(
    val id: UUID,
    val nickname: String,
    val fullName: String,
    val email: Email,
    val profileImage: Media,
    val following: List<User>,
    val followers: List<User>,
    val bio: String,
    val occupation: String,
    val address: String,
    val savedRecipes: List<Post<Recipe>>,
)

@JvmInline
value class Email(val address: String)