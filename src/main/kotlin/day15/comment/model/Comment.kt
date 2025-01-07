package org.hyunjung.day15.comment.model

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)