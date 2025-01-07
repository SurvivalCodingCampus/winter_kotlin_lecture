package org.example.day14

import kotlinx.coroutines.runBlocking
import org.example.day14.data.repository.UserDataSourceImpl
import org.example.day14.data.result.Result
import org.example.day14.data.result.asResult

fun main(): Unit = runBlocking {
    val userRepo = UserDataSourceImpl()

    userRepo.getUsersFromUrl().asResult().collect { result ->
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

    userRepo.getUser(1).asResult().collect { result ->
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
    println(userRepo.getUser())
    println(userRepo.getUser())
}