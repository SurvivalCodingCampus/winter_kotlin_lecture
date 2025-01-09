package day17.mapper

import day17.dto.StoreDto
import day17.model.Store

fun StoreDto.toStore() = Store(
    addr = addr ?: "",
    name = name ?: "",
    remainStat = remain_stat ?: "",
    stockAt = stock_at ?: "",
    createdAt = created_at ?: ""
)