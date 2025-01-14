package day19.repository

import day19.model.Profile

interface ProfileRepository {
    suspend fun getProfileById(userId: Int): Profile
}