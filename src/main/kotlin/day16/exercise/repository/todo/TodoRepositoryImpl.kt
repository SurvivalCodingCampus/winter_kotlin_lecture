package day16.exercise.repository.todo

import day15.common.ResponseResult
import day15.model.Todo
import day16.exercise.datasource.todo.TodoDataSource
import io.ktor.serialization.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoRepositoryImpl(
    private val todoDataSource: TodoDataSource
) : TodoRepository {
    override suspend fun getTodos(): List<Todo> = withContext(Dispatchers.IO) {
        when (val result = todoDataSource.getTodos()) {
            is ResponseResult.Success -> {
                println("통신 성공")
                result.data
            }

            is ResponseResult.Failure -> {
                // 실패한 경우 상태 코드에 따라 예외를 던짐
                emptyList()   // 실패한 경우 빈 리스트 리턴
            }
        }
    }

    override suspend fun getTodo(id: Int): Todo? = withContext(Dispatchers.IO) {
        when (val result = todoDataSource.getTodo(id)) {
            is ResponseResult.Success -> {
                println("성공")
                result.data
            }

            is ResponseResult.Failure -> {
                println("실패 ${result.exception}")// 예외를 던지도록 수정
                if (result.exception is JsonConvertException) {
                    throw IllegalArgumentException("Todo with ID $id not found")
                }
                null
            }
        }
    }
}