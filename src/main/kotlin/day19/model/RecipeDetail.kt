package day19.model

data class RecipeDetail(
    val id: Int,
    val title: String,
    val cookingMinute: Int,
    val thumbnailUrl: String,
    val rating: Double,
    val authorName: String,
    val authorAvatarUrl: String,
    val authorRegion: String,
    val authorId: Int,
    val ingredients: List<Ingredient>,
    val procedure: List<String>,
    val videoLinkUrl: String,
)
