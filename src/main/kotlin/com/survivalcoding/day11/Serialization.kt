package com.survivalcoding.com.survivalcoding.day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

//{
//    "name": "홍길동",
//    "email": "aaa@ccc.com",
//}


fun main() {
    val user = User(name = "홍길동", email = "aaa@ccc.ccc")

    val file = File("User.txt")
    val json = Json.encodeToString(user)
    file.writeText(json)

    val user2 = Json.decodeFromString<User>(json)
    println(user2.toString())
}

@Serializable
data class User(
    val name: String,
    val email: String,
)

//fun main() {
//    val user = User(name = "홍길동", email = "aaa@ccc.ccc")
//
//    val file = File("User.txt")
//    file.writeText(user.toJson())
//
//    val user2 = User.fromJson(user.toJson())
//    println(user2.toString())
//}

data class UserNogada(
    val name: String,
    val email: String,
) {
    fun toJson() = """
        {
            "name": "$name",
            "email": "$email"
        }       
    """.trimIndent()

    companion object {
        fun fromJson(json: String): User {
            val name = json.substringAfter("\"name\": \"")
                .substringBefore("\"")
            val email = json.substringAfter("\"email\": \"")
                .substringBefore("\"")
            return User(name, email)
        }
    }
}