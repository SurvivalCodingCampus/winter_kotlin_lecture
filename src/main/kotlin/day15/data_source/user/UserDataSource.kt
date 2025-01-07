package org.example.day15.data_source.user

import org.example.day14.user.UserData
import org.example.day15.data_source.DataSource

interface UserDataSource : DataSource {
    suspend fun getUsers(): List<UserData>
}