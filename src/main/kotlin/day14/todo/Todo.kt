package org.example.day14.todo

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
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