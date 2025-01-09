package day17

import day17.dto.StoreDto
import day17.model.Coordinates
import day17.model.Store
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.format.char

fun StoreDto.toStore(): Store {
    val defaultDate = LocalDateTime(LocalDate.fromEpochDays(0), LocalTime.fromSecondOfDay(0))
    val formatter = LocalDateTime.Format {
        year(); char('/'); monthNumber(); char('/'); dayOfMonth()
        char(' ')
        hour(); char(':'); minute(); char(':'); second()
    }

    return Store(
        name = name ?: "N/A",
        coordinates = Coordinates(lat ?: 200.0, lng ?: 200.0),
        fullAddress = addr ?: "N/A",
        remaining = Store.Amount.of(remain_stat ?: "unknown"),
        lastChecked = created_at?.let { LocalDateTime.parse(it, formatter) } ?: defaultDate,
        stockedTime = stock_at?.let { LocalDateTime.parse(it, formatter) } ?: defaultDate,
    )
}