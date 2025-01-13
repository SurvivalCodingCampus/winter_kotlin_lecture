package day19.model

data class Recipe(
    val ingredients: List<Ingredient>,
    val instruction: List<Steps>,
    val starRating: Float,
    val servings: Int,
) {
    data class Steps(
        val title: String,
        val description: String,
    )
}
