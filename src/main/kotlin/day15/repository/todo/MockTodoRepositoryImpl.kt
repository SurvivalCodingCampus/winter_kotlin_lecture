package day15.repository.todo

import day15.common.ResponseResult
import day16.exercise.datasource.todo.TodoDataSource
import day15.model.Todo

class MockTodoRepositoryImpl(
    private val todoDataSource: TodoDataSource
) : TodoRepository {
    override suspend fun getTodos(): List<Todo> {
        return when (val result = todoDataSource.getTodos()) {
            is ResponseResult.Success -> {
                result.data
            }

            is ResponseResult.Failure -> {
                println("Todo 데이터 받아오기 실패: ${result.exception.message}")
                emptyList()
            }
        }
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        return when (val result = todoDataSource.getTodos()) {
            is ResponseResult.Success -> {
                result.data.filter { it.completed }
            }

            is ResponseResult.Failure -> {
                println("Todo 데이터 받아오기 실패: ${result.exception.message}")
                emptyList()
            }
        }
    }
}
