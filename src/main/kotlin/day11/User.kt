package day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class User(
    val name: String,
    val email: String,
)

fun main() {
    // 직렬화
    val json = Json.encodeToString(User("홍길동", "hkd@naver.com"))
    println(json)  // {"name":"홍길동","email":"hkd@naver.com"}

    // 역직렬화
    val obj = Json.decodeFromString<User>(json)
    println(obj)  // User(name=홍길동, email=hkd@naver.com)
}