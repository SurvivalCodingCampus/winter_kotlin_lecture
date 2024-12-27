package com.survivalcoding.com.survivalcoding.day05

import java.time.LocalDate

class Person2(
    val name: String,
    val birthYear: Int,
    val localDate: LocalDate = LocalDate.now()
) {
    val age: Int
        get() = localDate.year - birthYear
}