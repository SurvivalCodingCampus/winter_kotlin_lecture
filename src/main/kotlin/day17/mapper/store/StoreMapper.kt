package org.example.day17.mapper.store

import org.example.day17.dto.store.StoreDTO
import org.example.day17.dto.store.Type
import org.example.day17.model.store.Store

fun StoreDTO.toStore() = Store(
    addr = addr ?: "",
    code = code ?: "",
    createdAt = createdAt ?: "",
    lat = lat ?: -1.0,
    lng = lng ?: -1.0,
    name = name ?: "",
    remainStat = remainStat ?: "",
    stockAt = stockAt ?: "",
    type = Type.checkType(type).type
)