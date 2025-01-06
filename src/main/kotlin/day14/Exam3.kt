package org.example.day14

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company,
)

interface UserDataSource {
    suspend fun getTodo(): List<User>
}

class UserDataSourceImpl : UserDataSource {

    private val file = File("test_json3")
    private val json = file.readText()

    override suspend fun getTodo(): List<User> {
        return Json.decodeFromString(json)
    }
}

fun main() = runBlocking {
    val test = UserDataSourceImpl()

    val job = launch {
        println(test.getTodo().toString())
    }

}