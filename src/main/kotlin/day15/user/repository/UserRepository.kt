package org.hyunjung.day15.user.repository

import org.hyunjung.day15.user.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>
}