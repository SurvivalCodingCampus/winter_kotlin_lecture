package org.example.day14.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.data.model.User
import org.example.day14.data.resources.userJsonString
import org.example.day14.data.resources.usersJsonString
import org.example.day14.util.fetchData
import org.example.day14.util.jsonConfig

class UserDataSourceImpl : UserDataSource {
    private val url = "https://jsonplaceholder.typicode.com/users"

    override suspend fun getUser(): User {
        return jsonConfig.decodeFromString(userJsonString)
    }

    override suspend fun getUsers(): List<User> {
        return jsonConfig.decodeFromString(usersJsonString)
    }

    override suspend fun getUser(id: Int): Flow<User> = flow {
        emit(fetchData<User>("$url/$id"))
    }

    override suspend fun getUsersFromUrl(): Flow<List<User>> = flow {
        emit(fetchData<List<User>>(url))
    }
}