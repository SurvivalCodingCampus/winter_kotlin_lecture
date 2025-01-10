package day17.utils

import utils.network.ResponseResult
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun convertToDate(dateString: String?): LocalDate {


    return try {
        dateString?.let { date ->
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            LocalDate.parse(date, formatter)
        } ?: LocalDate.now()
    } catch (e: Exception) {
        LocalDate.now()
    }
}

fun main() {
    val result = ResponseResult.success("fds")
    println(result)
}