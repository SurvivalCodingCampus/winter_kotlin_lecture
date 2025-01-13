package org.hyunjung.day17.maskstore.dto

import kotlinx.serialization.Serializable

@Serializable
data class MaskStoreResponse(
    val count: Int,
    val stores: List<MaskStoreDto>
)