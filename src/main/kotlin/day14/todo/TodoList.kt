package org.example.day14.todo

data class TodoList(
    val todoItems: List<Todo>
) {
    companion object {
        fun fromData(todoDataList: List<TodoData>): TodoList {
            /// fromData 함수 중 에러가 발생하면 제거한다.
            return TodoList(
                todoItems = todoDataList.map { Todo.fromData(it) }
            )
        }
    }
}
