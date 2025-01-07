package day15.model

import kotlinx.serialization.Serializable


/*
* @author: JaeYoun Kim
* @since: 2025-01-07
*
*
* */

@Serializable
data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String,
)
