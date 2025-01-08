package day15.repository

import day15.model.User

interface UserRepository {
    suspend fun getUsers() : List<User>
    suspend fun getUsersTop10ByUserName() : List<User>
}

