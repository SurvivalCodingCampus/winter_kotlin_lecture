package org.example.day14.todo

object TodoMapper {
    fun fromData(todoData: TodoData?): Todo {
        if (todoData == null) {
            return Todo.init()
        }
        return Todo(
            userId = todoData.userId ?: -1,
            id = todoData.id ?: -1,
            title = todoData.title ?: "",
            completed = todoData.completed == true
        )
    }

    fun fromDataList(todoDataList: List<TodoData>): List<Todo> {
        return todoDataList.map { fromData(it) }
    }
}