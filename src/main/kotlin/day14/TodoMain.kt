package org.example.day14

import kotlinx.coroutines.runBlocking
import org.example.day14.data.mock.MockTodoDataSourceImpl
import org.example.day14.data.result.Result
import org.example.day14.data.result.asResult

fun main() = runBlocking {
    val todoRepo = MockTodoDataSourceImpl()
    todoRepo.getTodos().asResult().collect { result ->
        when (result) {
            is Result.Success -> {
                result.data.forEach {
                    println(it)
                }
            }

            is Result.Error -> throw result.exception
            Result.Loading -> {
                println("로딩 중..")
            }
        }
    }

    todoRepo.getTodo(1).asResult().collect { result ->
        when (result) {
            is Result.Success -> {
                println(result.data)
            }

            is Result.Error -> throw result.exception
            Result.Loading -> {
                println("로딩 중..")
            }
        }
    }
}