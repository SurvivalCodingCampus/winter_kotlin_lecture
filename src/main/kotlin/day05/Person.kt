package org.example.day05

import java.time.LocalDate

class Person(val name: String, val birthDay: Int, val localDate: LocalDate = LocalDate.now()) {
    val age: Int
        get() = localDate.year - birthDay
}