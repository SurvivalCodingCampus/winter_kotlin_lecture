package org.hyunjung.day15.user.datasource

import org.hyunjung.day15.user.model.User

interface UserDataSource {
    suspend fun getUsers(): List<User>
}