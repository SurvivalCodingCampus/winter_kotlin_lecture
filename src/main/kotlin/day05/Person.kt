package org.hyunjung.day05

import java.time.LocalDate

class Person(
    val name: String,
    val birthYear: Int
) {
    init {
        require(name.isNotBlank()) { "이름은 비어 있을 수 없습니다." }
        require(birthYear <= LocalDate.now().year) {
            "태어난 해는 현재 연도(${LocalDate.now().year})보다 클 수 없습니다."
        }
    }

    val age: Int
        get() {
            val currentYear = LocalDate.now().year
            return currentYear - birthYear
        }
}