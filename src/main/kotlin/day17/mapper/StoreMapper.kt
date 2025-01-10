package org.example.day17.mapper

import day17.StoreDto
import org.example.day17.model.RemainState
import org.example.day17.model.Store
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val yyyyMMddHHmmssDateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")

fun StoreDto.toModel(): Store {
    return Store(
        address = addr ?: "",
        code = code?.toInt() ?: 0,
        createAt = if (created_at != null) LocalDateTime.parse(
            created_at,
            yyyyMMddHHmmssDateFormatter
        ) else LocalDateTime.MIN,
        name = name ?: "",
        remainState = RemainState.fromString(remain_stat),
    )
}
