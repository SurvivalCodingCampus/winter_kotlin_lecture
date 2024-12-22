package utils

import java.time.LocalDate
import java.util.Calendar

object CommonUtils {
    fun getCurrentDate(): String {
        val localDate: LocalDate = LocalDate.now()
        return localDate.toString()
    }

    fun getCurrentYear(): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.YEAR)
    }
}