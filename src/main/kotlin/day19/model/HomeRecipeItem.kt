package org.hyunjung.day19.model

data class HomeRecipeItem(
    val foodIconUrl: String,
    val cookingMinute: Int,
    val title: String,
    val rating: Double,
    val isBookmarked: Boolean,
)