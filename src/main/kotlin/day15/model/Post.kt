package day15.model

import kotlinx.serialization.Serializable

@Serializable
class Post (
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)