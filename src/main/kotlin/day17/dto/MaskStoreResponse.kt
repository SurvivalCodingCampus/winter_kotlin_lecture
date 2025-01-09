package org.example.day17.dto

import kotlinx.serialization.Serializable
import org.example.day17.model.MaskStore
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Serializable
data class MaskStoreResponse(
    val addr: String?,
    val code: String?,
    val created_at: String?,
    val lat: Double?,
    val lng: Double?,
    val name: String?,
    val remain_stat: String?,
    val stock_at: String?,
    val type: String?
)

fun MaskStoreResponse.isValidDate(): Boolean = when {
    addr.isNullOrBlank() -> false
    code.isNullOrBlank() -> false
    created_at.isNullOrBlank() -> false
    lat == null -> false
    lng == null -> false
    name.isNullOrBlank() -> false
    remain_stat.isNullOrBlank() -> false
    stock_at.isNullOrBlank() -> false
    type.isNullOrBlank() -> false
    else -> true
}

fun MaskStoreResponse.asMaskStore() = MaskStore(
    address = addr ?: "NONE",
    code = code ?: "NONE",
    createdDate = created_at.asLocalDate(),
    lat = lat ?: 0.0,
    lng = lng ?: 0.0,
    name = name ?: "NONE",
    remainStat = remain_stat ?: "NONE",
    stockDate = stock_at.asLocalDate(),
    type = type ?: "NONE"
)

private fun String?.asLocalDate(): LocalDate {
    if (this.isNullOrBlank()) {
        return LocalDate.MIN
    }

    return if (this.matches("""^\d{4}/\d{2}/\d{2} \d{2}:\d{2}:\d{2}$""".toRegex())) {
        LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))
    } else {
        LocalDate.MIN
    }
}
