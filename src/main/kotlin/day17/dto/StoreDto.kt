package day17.dto

import kotlinx.serialization.Serializable

@Serializable
data class StoreResponse(
    val count: Int? = null,
    val stores: List<StoreDto>? = null
)

@Serializable
data class StoreDto(
    val addr: String? = null,
    val code: String? = null,
    val created_at: String? = null,
    val lat: Double? = null,
    val lng: Double? = null,
    val name: String? = null,
    val remain_stat: String? = null,
    val stock_at: String? = null,
    val type: String? = null
)
