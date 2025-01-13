package org.hyunjung.day19.repository

import org.hyunjung.day19.model.Review

interface ReviewRepository {
    suspend fun getReviewsByRecipeId(id: Int): List<Review>
    suspend fun getReviewsByUserId(id: Int): List<Review>
    suspend fun editReview(id: Int, editedReview: Review): Boolean
    suspend fun sendReview(review: Review): Boolean
    suspend fun deleteReview(id: Int): Boolean
}