package org.example.day17.dto.store

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreResult(
    val count: Int?,
    val stores: List<StoreDTO>?,
)

@Serializable
data class StoreDTO(
    val addr: String?,
    val code: String?,
    @SerialName("created_at") val createdAt: String?,
    val lat: Double?,
    val lng: Double?,
    val name: String?,
    @SerialName("remain_stat") val remainStat: String?,
    @SerialName("stock_at") val stockAt: String?,
    val type: String?,
)

enum class Type(val type: String) {
    약국("01"),
    우체국("02"),
    농협("03"),
    UNKNOWN("unknown");

    companion object {
        fun checkType(typeNum: String?): Type {
            return entries.find { it.type == typeNum } ?: UNKNOWN
        }
    }
}