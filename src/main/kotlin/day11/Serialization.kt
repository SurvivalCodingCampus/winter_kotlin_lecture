package day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun main() {
    // 직렬화
    val json = Json.encodeToString(User("홍길동", "aaa@bbb.com"))
    println(json)

    // 역직렬화
    val obj = Json.decodeFromString<User>(json)
}


@Serializable
data class User (
    val name: String,
    val email: String,
) {
    // 직렬화
    fun toJson(): String = """
        {
            "name": "$name",
            "email": "$email"
        }
    """.trimIndent()

    // 역직렬화
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