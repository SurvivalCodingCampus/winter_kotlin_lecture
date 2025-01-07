package org.example.day15.repository

import org.example.day15.data_source.UserDataSource
import org.example.day15.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>

}

class UserRepositoryImpl(private val dataSource: UserDataSource) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return dataSource.getUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return getUsers().sortedBy { it.username }.slice(0..9)
    }
}