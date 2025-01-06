package org.example.day14

import kotlinx.coroutines.runBlocking
import org.example.day14.data.repository.TodoDataSourceImpl
import org.example.day14.data.result.Result
import org.example.day14.data.result.asResult

fun main(): Unit = runBlocking {
    TodoDataSourceImpl().getTodos("https://jsonplaceholder.typicode.com/todos").asResult().collect { result ->
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

    TodoDataSourceImpl().getTodo("https://jsonplaceholder.typicode.com/todos", 1).asResult().collect { result ->
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
    println(TodoDataSourceImpl().getTodo())
    println(TodoDataSourceImpl().getTodos())
}