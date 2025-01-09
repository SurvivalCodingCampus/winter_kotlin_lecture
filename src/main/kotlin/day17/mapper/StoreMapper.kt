package day17.mapper

import day17.dto.StoreDto
import day17.model.Store

// StoreMapper
fun StoreDto.mapper(): Store {
    return Store(
        address = addr ?: "",
        code = code ?: "",
        createdAt = createdAt ?: "",
        lat = lat ?: 0.0,
        lng = lng ?: 0.0,
        name = name ?: "",
        remainStat = remainStat ?: "",
        stockAt = stockAt ?: "",
        type = type ?: ""
    )
}