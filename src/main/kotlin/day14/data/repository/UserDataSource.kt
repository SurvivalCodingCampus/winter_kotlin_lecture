package org.example.day14.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.day14.data.model.User

interface UserDataSource {
    suspend fun getUser(): User
    suspend fun getUser(id: Int): Flow<User>
    suspend fun getUsers(): List<User>
    suspend fun getUsersFromUrl(): Flow<List<User>>
}