package day16.exercise.repository.todo

import day15.common.ResponseResult
import day15.model.Todo
import day16.exercise.datasource.todo.TodoDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoRepositoryImpl(
    private val todoDataSource: TodoDataSource
) : TodoRepository {
    override suspend fun getTodos(): List<Todo> = withContext(Dispatchers.IO) {
        when (val result = todoDataSource.getTodos()) {
            is ResponseResult.Success -> {
                result.data
            }

            is ResponseResult.Failure -> {
                emptyList()
            }
        }
    }

    override suspend fun getTodo(id: Int): Todo? = withContext(Dispatchers.IO) {
        when (val result = todoDataSource.getTodo(id)) {
            is ResponseResult.Success -> {
                result.data
            }

            is ResponseResult.Failure -> {
                null
            }
        }
    }
}