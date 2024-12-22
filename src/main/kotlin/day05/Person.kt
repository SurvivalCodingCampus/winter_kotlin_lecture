package org.example.day05

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Person(
    val name: String,
    val birthYear: Int,
) {
    init {
        require(birthYear > 1900) {
            "생년이 유효하지 않습니다."
        }
    }
    companion object {
        private fun getCurrentYear(): Int =
            LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy")).toInt()
    }

    var age: Int =  getCurrentYear() - birthYear
        private set
}