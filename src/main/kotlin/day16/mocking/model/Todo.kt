package org.hyunjung.day16.mocking.model

import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val id: Int = -1,
    val title: String = "Unknown",
    val completed: Boolean = false
)
