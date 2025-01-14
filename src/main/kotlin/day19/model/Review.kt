package org.hyunjung.day19.model

data class Review(
    val id: Int,
    val postId: Int,
    val authorName: String,
    val authorAvatarUrl: String,
    val likedUserIds: Set<Int>,
    val hatedUserIds: Set<Int>,
    val date: String,
    val content: String
)