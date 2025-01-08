package org.example.day14.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.data.datasource.UserDataSource
import org.example.day14.data.model.User
import org.example.day14.util.fetchData
import org.example.day15.data.resource.BASE_URL

class UserRemoteDataSource : UserDataSource {
    override suspend fun getUsers(): Flow<List<User>> = flow {
        emit(fetchData<List<User>>("$BASE_URL/users"))
    }

    override suspend fun getUser(id: Int): Flow<User> = flow {
        emit(fetchData<User>("$BASE_URL/users/$id"))
    }
}