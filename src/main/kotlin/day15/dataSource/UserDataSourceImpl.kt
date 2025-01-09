package day15.dataSource

import day15.model.User
import day15.util.JsonData
import kotlinx.serialization.json.Json

class UserDataSourceImpl: UserDataSource {
    override suspend fun userData(): List<User> {
        return Json.decodeFromString<List<User>>(JsonData.USER_DATA)
    }
}