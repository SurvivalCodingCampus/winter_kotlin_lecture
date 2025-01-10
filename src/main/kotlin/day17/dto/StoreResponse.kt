package org.example.day17.dto

import kotlinx.serialization.Serializable

@Serializable
data class StoreResponse(
    val count: Int,
    val stores: List<StoreDto>
)

@Serializable
data class StoreDto(
    val addr: String,
    val code: String,
    val created_at: String?,
    val lat: Double,
    val lng: Double,
    val name: String,
    val remain_stat: String? = null,
    val stock_at: String? = null,
    val type: String
)