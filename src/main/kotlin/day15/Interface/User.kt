package org.example.day15.Interface

import org.example.day15.Model.User

interface UserRepositoryImpl {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>
}

interface UserDataSource {
    var users: List<User>
}
