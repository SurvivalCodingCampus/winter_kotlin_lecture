package day16.util

import java.text.SimpleDateFormat
import java.time.Duration
import java.util.*

object CommonUtils {
    // 날짜 변환 메소드
    fun formattedTime(timeInMillis: Long): String {
        // Duration은 나노초 단위까지 지원
        val duration = Duration.ofMillis(timeInMillis)

        val hours = duration.toHours()
        val minutes = duration.toMinutes() % 60
        val seconds = duration.seconds % 60
        val milliseconds = duration.toMillis() % 1000
        val micros = (timeInMillis % 1000) * 1000

        return String.format("%02d:%02d:%02d.%03d%03d", hours, minutes, seconds, milliseconds, micros)
    }

    //
}