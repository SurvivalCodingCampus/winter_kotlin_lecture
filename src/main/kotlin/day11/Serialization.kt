package org.example.day11

import java.io.File

fun main() {
    val user = User("Tom", "aaa@ddd.com")
    val file = File("user.json")
    file.writeText(user.toJson())
    println(user.toJson())
}

data class User(
    val name: String,
    val email: String,
) {
    /// 하드 코딩된 JSON 문자열을 반환하는 함수
    fun toJson(): String {
        return """
            {
                "name": "$name",
                "email": "$email"
            }
        """.trimIndent()
    }

}
