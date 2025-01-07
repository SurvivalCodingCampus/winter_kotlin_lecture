package org.example.day15.data_source

import kotlinx.serialization.json.Json
import org.example.day15.JsonData.USER_JSON
import org.example.day15.model.User

interface UserDataSource {
    suspend fun getUsers() : List<User>
}

class UserDataSourceImpl: UserDataSource {
    override suspend fun getUsers(): List<User> {
        return Json.decodeFromString(USER_JSON)
    }
}