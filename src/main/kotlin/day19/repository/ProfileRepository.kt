package org.hyunjung.day19.repository

import org.hyunjung.day19.model.Profile

interface ProfileRepository {
    suspend fun getProfileById(userId: Int): Profile
}