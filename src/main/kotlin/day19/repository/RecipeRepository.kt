package day19.repository

import day19.model.Post
import day19.model.Recipe
import day19.model.Tag

interface RecipeRepository {
    fun getRecentPosts(amount: Int): List<Post<Recipe>>
    fun <T> getSorted(comparator: Comparator<T>): List<Post<Recipe>>
    fun getFilteredRecipes(tags: Array<Tag> = arrayOf(Tag("all"))): List<Post<Recipe>>
    fun findRecipesByStarRating(range: IntRange): List<Post<Recipe>>
}