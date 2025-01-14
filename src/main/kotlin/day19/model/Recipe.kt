package day19.model

// 레시피 데이터 클래스
data class Recipe(
    val id: Int,
    val title: String,
    val cookingMinute: Int,
    val postTime: String,
    val category: RecipeCategory,
    val thumbnailUrl: String,
    val foodIconUrl: String,
    val rating: Double,
    val author: Profile,
    val ingredients: List<Ingredient>,
    val videoLink: String,
)
