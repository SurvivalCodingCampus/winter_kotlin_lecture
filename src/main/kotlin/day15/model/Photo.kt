package org.example.day15.model

import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    val albumId: Int = -1,
    val id: Int = -1,
    val title: String = "unknownTitle",
    val url: String = "unknownUrl",
    val thumbnailUrl: String = "unknownThumbnailUrl",
)