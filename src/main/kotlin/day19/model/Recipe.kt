package day19.model

data class Recipe(
    val ingredients: List<Ingredient>,
    val instruction: List<Steps>,
) {
    data class Steps(
        val title: String,
        val description: String,
    )
}
