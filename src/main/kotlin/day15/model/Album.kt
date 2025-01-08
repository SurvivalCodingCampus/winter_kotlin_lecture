package day15.model

import kotlinx.serialization.Serializable
/*
* @author: JaeYoun Kim
* @since: 2025-01-07
* */
@Serializable
data class Album(
    val userId: Int,
    val id: Int,
    val title: String,
)
