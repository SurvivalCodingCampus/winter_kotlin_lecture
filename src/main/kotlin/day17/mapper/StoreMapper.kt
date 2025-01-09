package org.example.day17.mapper

import org.example.day17.dto.StoreDto
import org.example.day17.model.Store

fun StoreDto.toStore() = Store(
    addr = addr,
    createdAt = created_at ?: "",
    lat = lat,
    lng = lng,
    name = name,
    remainStat = remain_stat ?: "",
    stockAt = stock_at ?: "",
)