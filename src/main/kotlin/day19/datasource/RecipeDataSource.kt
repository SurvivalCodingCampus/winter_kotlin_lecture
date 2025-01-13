package day19.datasource

import day19.dto.RecipeRequestBody
import day19.dto.RecipeResponse
import java.util.*

interface RecipeDataSource {
    fun createRecipe(id: UUID): Result<RecipeResponse>
    fun getRecipe(id: UUID): Result<RecipeResponse>
    fun updateRecipe(id: UUID, requestBody: RecipeRequestBody): Result<RecipeResponse>
    fun deleteRecipe(id: UUID): Result<RecipeResponse>
}