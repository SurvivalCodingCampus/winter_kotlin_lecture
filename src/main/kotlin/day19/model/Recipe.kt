package day19.model

data class Recipe(
    val ingredients: List<Ingredient>,
    val instruction: List<Steps>,
    val starRating: Float,
    val servings: Int,
    val tags: List<String>,
) {
    data class Steps(
        val title: String,
        val description: String,
    )
}
