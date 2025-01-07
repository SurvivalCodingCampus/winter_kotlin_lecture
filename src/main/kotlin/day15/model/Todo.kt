package day15.model

import kotlinx.serialization.Serializable

/*
* Made by JaeYoun Kim
* @since 2025.01.06
* */

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
)
