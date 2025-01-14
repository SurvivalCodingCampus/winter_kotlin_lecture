package day19.model

data class Profile(
    val id: Int,
    val name: String,
    val job: String,
    val avatarUrl: String,
    val bio: String,
    val postedRecipes: List<Recipe>,
    val followers: List<Int>,
    val followings: List<Int>,
    val region: String,
)