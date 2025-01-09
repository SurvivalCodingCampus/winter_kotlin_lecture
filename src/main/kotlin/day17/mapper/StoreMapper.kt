package day17.mapper

import day17.dto.StoreDto
import day17.model.Store
import day17.model.StoreType
import java.lang.NullPointerException
import java.time.LocalDateTime

fun StoreDto.toStore(): Store {
    var convertType: StoreType? = null

    when(type) {
        "01" -> convertType = StoreType.PHARMACY
        "02" -> convertType = StoreType.POSTOFFICE
        "03" -> convertType = StoreType.NA
        else -> StoreType.ERROR
    }
    return Store(
        addr = addr ?: "",
        createdAt = created_at ?: "",
        name = name ?: "",
        remainStat = remain_stat ?: "",
        stockAt = stock_at ?: "",
        type = convertType ?: StoreType.ERROR
    )
}