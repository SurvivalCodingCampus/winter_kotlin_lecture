package day17.dto

import day17.model.Store
import kotlinx.serialization.Serializable
import java.lang.NullPointerException
import java.time.LocalDateTime

@Serializable
data class MaskStoreResponse(
    val count: Int?,
    val stores: List<StoreDto>?
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

