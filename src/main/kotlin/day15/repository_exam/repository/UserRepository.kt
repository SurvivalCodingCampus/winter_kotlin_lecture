package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUsersTop10ByUserName(): List<User>
}