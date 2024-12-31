package day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class User(
    val name: String,
    val email: String,
) {
}

fun main() {
    val user = User("홍길동", "aaa@ccc.ccc")

    val file = File("User.txt")
    val json = Json.encodeToString(user)
    println(json)

    val obj = Json.decodeFromString<User>(json)
    println(obj)
}