package org.example.day15.model

import kotlinx.serialization.Serializable


@Serializable
data class Comment(
    val postId: Int = -1,
    val id: Int = -1,
    val name: String = "unknownName",
    val email: String = "unknownEmail",
    val body: String = "unknownBody",
)