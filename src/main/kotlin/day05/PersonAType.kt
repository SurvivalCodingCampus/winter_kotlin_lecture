package org.example.day05

import java.time.LocalDateTime

class PersonAType(
    val name: String,
    val birthYear: Int,
) {
    private val currentYear = LocalDateTime.now().year
    val age: Int
        get() = currentYear - birthYear

    init {
        require(birthYear in currentYear - 200..currentYear) { "태어난 년도를 확인 해주세요." }
        require(name.isNotEmpty()) { "이름을 확인 해주세요." }
    }
}