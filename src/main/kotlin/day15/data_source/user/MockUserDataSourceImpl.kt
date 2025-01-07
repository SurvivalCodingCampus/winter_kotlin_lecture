package day15.data_source.user

import day15.common.ResponseResult
import day15.common.safeCall
import day15.model.User
import day15.util.Urls
import kotlinx.serialization.json.Json

class MockUserDataSourceImpl: UserDataSource {
    override suspend fun getUsers(): ResponseResult<List<User>> {
        return safeCall {
            Json.decodeFromString(Urls.USER_DATA)
        }
    }
}