package day15.repository.todo

import day15.model.Todo

interface TodoRepository {

    // 전체 Todo 데이터 가져오기
    suspend fun getTodos(): List<Todo>

    // completed가 true인 경우만 체크
    suspend fun getCompletedTodos(): List<Todo>
}