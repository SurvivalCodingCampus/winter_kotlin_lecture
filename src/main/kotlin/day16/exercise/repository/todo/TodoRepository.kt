package day16.exercise.repository.todo

import day15.model.Todo

interface TodoRepository {
    // 전체 TODO 데이터 가져오기
    suspend fun getTodos(): List<Todo>

    // TODO 가져오기
    suspend fun getTodo(id: Int): Todo?
}