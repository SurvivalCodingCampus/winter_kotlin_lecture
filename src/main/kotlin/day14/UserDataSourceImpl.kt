package day14

import kotlinx.serialization.json.Json

class UserDataSourceImpl : UserDataSource {
    override suspend fun getUsers(): List<User> {
        return Json.decodeFromString<List<User>>(Data.USER_STRING)
    }
}