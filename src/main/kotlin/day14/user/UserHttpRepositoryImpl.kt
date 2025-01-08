package org.example.day14.user

import fuel.get
import kotlinx.io.readString
import kotlinx.serialization.json.Json

class UserHttpRepositoryImpl : UserHttpRepository {
    override suspend fun getUsers(): List<User> {

        return runCatching {
            val data = Json.decodeFromString<List<UserData>>(fuelClient.get(baseUrl).source.readString())
            UserMapper.fromDataList(data)
        }.getOrElse {
            println(it)
            emptyList()
        }
    }
}