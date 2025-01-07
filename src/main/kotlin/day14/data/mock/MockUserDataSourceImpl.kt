package org.example.day14.data.mock

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.data.datasource.UserDataSource
import org.example.day14.data.model.User
import org.example.day14.data.resources.usersJsonString
import org.example.day14.util.jsonConfig

class MockUserDataSourceImpl : UserDataSource {
    private val users = jsonConfig.decodeFromString<List<User>>(usersJsonString)
    override suspend fun getUsers(): Flow<List<User>> = flow {
        emit(users)
    }

    override suspend fun getUser(id: Int): Flow<User> = flow {
        emit(users.first { it.id == id })
    }
}