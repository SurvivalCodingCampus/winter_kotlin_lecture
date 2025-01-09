package day17.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
* JSON 응답 구조와 정확히 매핑되는 DTO 클래스
* */
@Serializable
data class MaskResponse(
    val count: Int? = null,
    val stores: List<StoreDto>? = null,
)

@Serializable
data class StoreDto(
    val addr: String? = null,
    val code: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    val lat: Double? = null,
    val lng: Double? = null,
    val name: String? = null,
    @SerialName("remain_stat")
    val remainStat: String? = null,
    @SerialName("stock_at")
    val stockAt: String? = null,
    val type: String? = null,
)


