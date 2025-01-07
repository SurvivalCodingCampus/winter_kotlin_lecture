package org.example.day15.repository.user

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import org.example.day14.user.UserData
import org.example.day15.data_source.user.UserDataSource

class UserRepositoryImpl(override val dataSource: UserDataSource) : UserRepository {
    override suspend fun getUsers(): List<UserData> = withContext(Dispatchers.IO) {
        try {
            dataSource.getUsers()
        } catch (e: Exception) {
            when (e) {
                is SerializationException -> throw e
                else -> emptyList()
            }
        }
    }

    override suspend fun getUsersTop10ByUserName(): List<UserData> = withContext(Dispatchers.IO) {
        try {
            dataSource.getUsers().sortedBy { it.username }.take(10)
        } catch (e: Exception) {
            when (e) {
                is SerializationException -> throw e
                else -> emptyList()
            }
        }
    }
}