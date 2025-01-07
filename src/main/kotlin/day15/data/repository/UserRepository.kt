package org.example.day15.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day14.data.model.User

interface UserRepository {
    suspend fun getUsersTop10ByUserName(): Flow<List<User>>
}