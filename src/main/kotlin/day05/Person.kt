package org.example.day05

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Person(
    val name: String,
    val birthYear: Int,
) {
    var age: Int = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy")).toInt() - birthYear
        private set
}