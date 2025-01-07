package day14.exercise.todo

import day14.exercise.JsonData
import day14.exercise.user.User
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json


class TodoDataSourceImpl : TodoDataSource {
    // 단일 데이터 불러오기
    override suspend fun getTodo(): Todo {

        return runCatching {
            Json.decodeFromString<Todo>(JsonData.TODO_JSON)
        }.getOrElse { exception ->
            throw RuntimeException("Json 파싱 실패: ${exception.message}", exception)
        }
    }

    override suspend fun getTodos(): List<Todo> {
        return runCatching {
            Json.decodeFromString<List<Todo>>(JsonData.TODO_LIST_JSON)
        }.getOrElse { exception ->
            throw RuntimeException("Json 파싱 실패: ${exception.message}", exception)
        }
    }
}


fun main() = runBlocking {
    val todoSource = TodoDataSourceImpl()
    val data = todoSource.getTodo()
    println(data)

    val listData = todoSource.getTodos()
    println(listData)
}