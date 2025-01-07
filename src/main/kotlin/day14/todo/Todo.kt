package org.example.day14.todo

import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val userId: Int = -1,
    val id: Int = -1,
    val title: String = "",
    val completed: Boolean = false,
) {
    companion object {
        fun init(): Todo {
            return Todo(
                userId = -1,
                id = -1,
                title = "",
                completed = false
            )
        }
    }
}