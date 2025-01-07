package day15.model

import kotlinx.serialization.Serializable

/*
* @author: JaeYoun Kim
* @since: 2025-01-07
* */
@Serializable
data class Photo(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String,
)
