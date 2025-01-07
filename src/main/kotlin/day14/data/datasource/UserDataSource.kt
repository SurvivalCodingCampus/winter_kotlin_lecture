package org.example.day14.data.datasource

import kotlinx.coroutines.flow.Flow
import org.example.day14.data.model.User

interface UserDataSource {
    suspend fun getUser(id: Int): Flow<User>
    suspend fun getUsers(): Flow<List<User>>
}