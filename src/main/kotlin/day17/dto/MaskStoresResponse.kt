package org.example.day17.dto

import kotlinx.serialization.Serializable

@Serializable
data class MaskStoresResponse(
    val count: Int?,
    val stores: List<MaskStoreResponse>?,
)
