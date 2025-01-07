package org.example.day15.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val userId: Int,
    val id: Int,
    val title: String,
)