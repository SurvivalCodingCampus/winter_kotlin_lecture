package org.example.day19.model

import java.time.LocalDateTime

data class Recipe(
    val id: String,
    val name: String,
    val authorName: String,
    val timeTaken: Int,
    val rate: Float,
    val circledThumbnailImageUrl: String,
    val thumbnailImageUrl: String,
    val isUserSaved: Boolean,
    val isUserReviewed: Boolean,
    val isUserRated: Boolean,
    val isNew: Boolean,
    val categories: List<String>,
    val createdAt: LocalDateTime
)