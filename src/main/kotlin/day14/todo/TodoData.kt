package org.example.day14.todo

import kotlinx.serialization.Serializable

@Serializable
data class TodoData(
    val userId: Int?,
    val id: Int?,
    val title: String?,
    val completed: Boolean?
)