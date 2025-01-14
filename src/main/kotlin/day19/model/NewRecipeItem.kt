package org.hyunjung.day19.model

data class NewRecipeItem(
    val thumbnailUrl: String,
    val cookingMinute: Int,
    val title: String,
    val rating: Double,
    val authorName: String,
    val authorAvatarUrl: String,
)