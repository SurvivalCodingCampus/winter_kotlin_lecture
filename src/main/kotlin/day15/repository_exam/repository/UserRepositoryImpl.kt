package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.data_source.UserDatasource
import org.example.day15.repository_exam.model.User

class UserRepositoryImpl(private val datasource: UserDatasource) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return datasource.getAllUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return datasource.getAllUsers().sortedBy { it.username }
    }
}