package org.hyunjung.day19.repository

import day19.model.Rate
import day19.model.TimeType
import org.hyunjung.day19.model.*

interface RecipeRepository {
    suspend fun getHomeRecipeList(category: RecipeCategory): List<HomeRecipeItem>
    suspend fun getNewRecipeList(): List<NewRecipeItem>
    suspend fun getSearchRecipeList(query: String): List<SearchRecipeItem>
    suspend fun getSavedRecipeList(): List<Recipe>
    suspend fun getRecipeDetail(recipeId: Int): RecipeDetail
    suspend fun getFilteredRecipe(time: TimeType?, rate: Rate?, category: RecipeCategory?): List<Recipe>?
}