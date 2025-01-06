package day14.exercise.user

import day14.exercise.JsonData
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class UserDataSourceImpl : UserDataSource {
    override suspend fun getUsers(): List<User> {
        return runCatching {
            Json.decodeFromString<List<User>>(JsonData.USER_DATA)
        }.getOrElse { exception ->
            throw RuntimeException("Json 파싱 실패: ${exception.message}", exception)
        }
    }

}

fun main() = runBlocking {
    val userDataSourceImpl = UserDataSourceImpl()
    val result = userDataSourceImpl.getUsers()
    println(result)
}