package day15.models

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val userId: Int,
    val id: Int,
    val title: String,
)