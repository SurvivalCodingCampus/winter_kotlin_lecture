package org.example.day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class User(
    val name: String,
    val email: String,
) {
//    fun toJson() = """
//        {
//            "name": "$name",
//            "email": "$email"
//        }
//    """.trimIndent()
}

fun main() {
    val user = User(name = "홍길동", email = "aaa@ccc.ddd")
//    val file = File("userInfo.txt")
//    file.writeText(user.toJson())

    // 직렬화
    val json = Json.encodeToString(user)
    println(json)
    // 역직렬화
    val obj = Json.decodeFromString<User>(json)
    println(obj)
}