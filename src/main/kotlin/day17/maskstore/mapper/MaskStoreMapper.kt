package org.hyunjung.day17.maskstore.mapper

import org.hyunjung.day17.maskstore.dto.MaskStoreDto
import org.hyunjung.day17.maskstore.model.Store

object MaskStoreMapper {
    fun map(dto: MaskStoreDto): Store? {
        if (dto.name.isNullOrBlank() || dto.addr.isNullOrBlank() || dto.lat == null || dto.lng == null ||
            dto.remainStat.isNullOrBlank() || dto.stockAt.isNullOrBlank()) {
            return null
        }

        return Store(
            name = dto.name,
            address = dto.addr,
            latitude = dto.lat,
            longitude = dto.lng,
            stockStatus = dto.remainStat,
            stockUpdatedAt = dto.stockAt
        )
    }
}