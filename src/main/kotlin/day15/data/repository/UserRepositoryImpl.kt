package org.example.day15.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import org.example.day14.data.datasource.UserDataSource
import org.example.day14.data.model.User

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
) : UserRepository {
    override suspend fun getUsersTop10ByUserName(): Flow<List<User>> =
        userDataSource.getUsers().map { user -> user.sortedBy { it.name } }.take(10)
}