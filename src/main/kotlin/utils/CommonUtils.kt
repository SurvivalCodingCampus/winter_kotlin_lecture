package utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object CommonUtils {
    /**
     * 연도를 바로 반환
     * @return 현재 날짜 연도 (ex) 2024)
     */
    fun getCurrentYear(): Int {
        return LocalDate.now().year
    }

    /**
     * 현재 날짜의 연 월 일을 반환
     * @return 현재 날짜 연도 (ex) 2024-12-22)
     */
    fun getCurrentDate(): LocalDate {
        return LocalDate.now()
    }

    fun LocalDateTime.simpleFormatter(): String {
        return this.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    }
}