package org.hyunjung.day11

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun main() {
    // 직렬화
    val json = Json.encodeToString(User("홍길동", "aaa@bbb.com"))
    println(json)

    // 역직렬화
    val obj = Json.decodeFromString<User>(json)
    println(obj)
}