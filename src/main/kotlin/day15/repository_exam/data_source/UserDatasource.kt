package org.example.day15.repository_exam.data_source

import org.example.day15.repository_exam.model.User

interface UserDatasource {
    fun getUser(id: Int): User?
    fun saveUser(user: User)
    fun getAllUsers(): List<User>
}