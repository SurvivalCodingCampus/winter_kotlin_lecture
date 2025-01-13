package day19.repository

import day19.model.Post
import day19.model.Recipe
import day19.model.Tag

interface RecipeRepository {
    fun getRecentPosts(amount: Int): Set<Post<Recipe>>
    fun <T> getSorted(comparator: Comparator<T>): Set<Post<Recipe>>
    fun getFilteredRecipes(tags: Array<Tag> = arrayOf(Tag("all"))): Set<Post<Recipe>>
    fun findRecipesByStarRating(range: IntRange): Set<Post<Recipe>>
}