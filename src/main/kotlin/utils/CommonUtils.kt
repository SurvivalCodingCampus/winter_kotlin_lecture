package utils

import java.time.LocalDate

object CommonUtils {
    fun getCurrentDate(): String {
        val localDate: LocalDate = LocalDate.now()
        println("현재 날짜 잘 가져오니? $localDate")
        return localDate.toString()
    }
}