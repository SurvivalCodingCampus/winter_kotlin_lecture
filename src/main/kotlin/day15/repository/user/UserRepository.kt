package org.example.day15.repository.user

import org.example.day14.user.UserData
import org.example.day15.data_source.user.UserDataSource

interface UserRepository {
    val dataSource: UserDataSource
    suspend fun getUsers(): List<UserData>
    suspend fun getUsersTop10ByUserName(): List<UserData>
}