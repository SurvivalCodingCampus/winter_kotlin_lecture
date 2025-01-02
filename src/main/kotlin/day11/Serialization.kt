package day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


/*
* JSON 으로 직렬화,역직렬화
* */
fun main() {
    // 직렬화
    val json = Json.encodeToString(User("홍길동", "test@gmail.com"))
    println(json)

    // 역직렬화
    val obj = Json.decodeFromString<User>(json)
    println(obj)
}

@Serializable
data class User(
    val name: String,
    val email: String,
)
