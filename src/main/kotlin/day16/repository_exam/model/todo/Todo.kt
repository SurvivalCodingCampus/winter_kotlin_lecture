package org.example.day16.repository_exam.model.todo

import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val id: Int,
    val title: String,
    val completed: Boolean,
)