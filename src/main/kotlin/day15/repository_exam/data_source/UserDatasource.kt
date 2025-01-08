package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.User

interface UserDatasource {
    suspend fun getUser(id: Int): User?
    suspend fun saveUser(user: User)
    suspend fun getAllUsers(): List<User>
}