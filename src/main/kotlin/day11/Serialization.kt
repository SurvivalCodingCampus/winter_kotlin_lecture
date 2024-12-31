package org.example.day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

//{
//    "name": "홍길동",
//    "email": "aaa@ccc.com"
//}

fun main() {
    val user = User(name = "홍길동", email = "aaa@ccc.ccc")
    val file = File("User.txt")

    // 직렬화
    val json = Json.encodeToString(user)
    file.writeText(json)
    println(json)

    // 역직렬화
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

data class Usernogada(
    val name: String,
    val email: String,
) {
    // 직렬화
    fun toJson() = """
        {
            "name": "$name",
            "email": "$email"
        }
    """.trimIndent()

    companion object {
        // 역직렬화
        fun fromJson(json: String): User {
            // 간단한 파싱 (실제로는 정규식이나 파서 사용 권장)
            val name = json.substringAfter("\"name\": \"")
                .substringBefore("\"")

            val email = json.substringAfter("\"email\": \"")
                .substringBefore("\"")

            return User(name, email)
        }
    }
}
