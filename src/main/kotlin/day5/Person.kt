package day5

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class Person(
    val name: String,
    val birthYear: Int,
) {
    private val timeZone = TimeZone.currentSystemDefault()

    val age: Int
        get() {
            val today = Clock.System.now()
            val year = today.toLocalDateTime(timeZone).year
            return year - birthYear
        }
}