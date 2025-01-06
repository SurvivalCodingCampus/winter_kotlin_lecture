package org.example.day14.todo

import org.example.domain.error.MissingFieldError


data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
) {

    companion object {
        fun fromData(todoData: TodoData): Todo {
            return Todo(
                userId = todoData.userId ?: throw MissingFieldError("userId"),
                id = todoData.id ?: throw MissingFieldError("id"),
                title = todoData.title ?: throw MissingFieldError("title"),
                completed = todoData.completed ?: throw MissingFieldError("completed")
            )
        }
    }
}