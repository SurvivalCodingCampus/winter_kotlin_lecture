package day19.repository

import day19.model.Post
import day19.model.Recipe
import day19.model.Tag
import java.util.*

interface RecipeRepository {
    fun getRecentPosts(amount: Int): Set<Post<Recipe>>
    fun <T> getSorted(comparator: Comparator<T>): Set<Post<Recipe>>
    fun findPostByAuthor(userId: UUID): Set<Post<Recipe>>
    fun getFiltered(tags: Array<Tag> = arrayOf(Tag("all"))): Set<Post<Recipe>>
    fun findByStarRating(range: IntRange): Set<Post<Recipe>>
    fun findBySearchTerm(vararg keywords: String): Set<Post<Recipe>>

    fun createRecipe(content: Post<Recipe>): Result<Post<Recipe>>
    fun editRecipe(id: UUID, newPost: Post<Recipe>): Result<Post<Recipe>>
    fun deleteRecipe(id: UUID): Result<Post<Recipe>>
}