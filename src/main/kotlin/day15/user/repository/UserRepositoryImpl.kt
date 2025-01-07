package org.hyunjung.day15.user.repository

import org.hyunjung.day15.user.datasource.UserDataSource
import org.hyunjung.day15.user.model.User

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return userDataSource.getUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        val users = userDataSource.getUsers()
        return users.sortedBy { it.username }.take(10)
    }
}